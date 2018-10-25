package com.company;

import java.util.ArrayList;

public final class AddressInfo {
    private static final int NUMBER_OF_ARGUMENTS = 2;
    private static final int NUMBER_OF_ADDRESS_PARAMETERS = 4;
    private static final int MAX_VALID_NUMBER = 255;
    private static final int MIN_VALID_NUMBER = 0;

    private int[] ipAddress;
    private int[] subnetMask;

    public AddressInfo(String[] args) {
        try {
            checkNumberOfArguments(args.length);
            ipAddress = convertArgumentInIntArray(args[0]);
            subnetMask = convertArgumentInIntArray(args[1]);
        } catch (IllegalArgumentException argumentEx) {
            System.out.println(argumentEx.getMessage());
        }
    }

    private void checkNumberOfArguments(int numberOfArguments) {
        if (numberOfArguments != NUMBER_OF_ARGUMENTS) {
            throw new IllegalArgumentException("input string mast have " + NUMBER_OF_ARGUMENTS + " arguments");
        }
    }

    private int[] convertArgumentInIntArray(String str) {
        String[] partsOfAddress = str.split("[.]");
        if (partsOfAddress.length != NUMBER_OF_ADDRESS_PARAMETERS) {
            throw new IllegalArgumentException("argument " + str + "must have " + NUMBER_OF_ADDRESS_PARAMETERS + " parameters");
        }

        int[] resultArray = new int[NUMBER_OF_ADDRESS_PARAMETERS];
        for (int i = 0; i < partsOfAddress.length; ++i) {
            int number = Integer.parseInt(partsOfAddress[i]);
            if ((number <= MAX_VALID_NUMBER) && (number >= MIN_VALID_NUMBER)) {
                resultArray[i] = number;
            }
            else
            {
                throw new IllegalArgumentException("parts of address must be less than 256 and more than -1");
            }
        }

        return resultArray;
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
}
