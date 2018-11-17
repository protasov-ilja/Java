import java.util.ArrayList;

public final class AddressInfo {
	private static final int NUMBER_OF_ARGUMENTS = 2;
	private static final int NUMBER_OF_ADDRESS_PARAMETERS = 4;
	private static final int MAX_VALID_NUMBER = 255;
	private static final int MIN_VALID_NUMBER = 0;

	private int[] ipAddress;
	private int[] subnetMask;

	public AddressInfo(String[] args) {

			checkNumberOfArguments(args.length);
			ipAddress = convertArgumentInIntArray(args[0], false);
			subnetMask = convertArgumentInIntArray(args[1], true);
			if (!isSubnetMask(subnetMask)) {
				throw new IllegalArgumentException("Wrong mask");
			}
	}

	private void checkNumberOfArguments(int numberOfArguments) {
		if (numberOfArguments != NUMBER_OF_ARGUMENTS) {
			throw new IllegalArgumentException("GetNetAddress <IP address> <Subnet mask>");
		}
	}

	private int[] convertArgumentInIntArray(String str, boolean isMask) {
		try {
			if (str.isEmpty() || str.endsWith(".")) {
				throw new IllegalArgumentException();
			}

			String[] partsOfAddress = str.split("\\.");
			if (partsOfAddress.length != NUMBER_OF_ADDRESS_PARAMETERS) {
				throw new IllegalArgumentException();
			}

			int[] resultArray = new int[partsOfAddress.length];
			for (int i = 0; i < partsOfAddress.length; ++i) {
				int number = Integer.valueOf(partsOfAddress[i]);
				if ((number <= MAX_VALID_NUMBER) && (number >= MIN_VALID_NUMBER) && (partsOfAddress[i].charAt(0) != '-')) {
					resultArray[i] = number;
				}
				else
				{
					throw new IllegalArgumentException();
				}
			}

			return resultArray;
		} catch (Exception er) {
			if (isMask)
			{
				throw new IllegalArgumentException("Wrong mask");
			}

			throw new IllegalArgumentException("Wrong ip address");
		}
	}

	public ArrayList<Byte> getIpAddressInBytes() {
		ArrayList<Byte> subnetMaskInBytes = new ArrayList<>();
		for (int i = 0; i < subnetMask.length; ++i) {
			byte numberInBytes = (byte)subnetMask[i];
			subnetMaskInBytes.add(numberInBytes);
		}

		return subnetMaskInBytes;
	}

	public ArrayList<Byte> getSubnetMaskInBytes() {
		ArrayList<Byte> ipAddressInBytes = new ArrayList<>();
		for (int i = 0; i < ipAddress.length; ++i) {
			byte numberInBytes = (byte)ipAddress[i];
			ipAddressInBytes.add(numberInBytes);
		}

		return ipAddressInBytes;
	}

	private boolean isSubnetMask(int[] maskArray) {
		int mask = 128;
		for(int number : maskArray) {
			int currNumber = number;
			for (int i = 0; i < 8; i++) {
				if ((currNumber & 128) != 0 && mask == 0) {
					return false;
				}

				if ((currNumber & mask) != mask) {
					mask = 0;
				}

				currNumber <<=  1;
			}
		}

		return true;
	}
}
