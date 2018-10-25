package com.company;

import java.util.ArrayList;

public class Main {
    private static final String HELP_INFO = "please write <ip address> and <subnet mask> in this format: x.x.x.x where x is number in range [0 .. 255]";

    public static void main(String[] args) {
        try {
            AddressInfo addressInfo = new AddressInfo(args);
            int[] netAddress = getNetAddress(addressInfo.getIpAddressInBytes(), addressInfo.getSubnetMaskInBytes());
            printNetAddress(netAddress);
        } catch (Exception er) {
            System.out.println(er.getMessage());
            System.out.println(HELP_INFO);
        }
    }

    private static int[] getNetAddress(ArrayList<Byte> ipAddress, ArrayList<Byte> subnetMask) {
        ArrayList<Byte> netAddressInBytes = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            netAddressInBytes.add(((byte)(ipAddress.get(i) & subnetMask.get(i))));
        }

        return convertFromByteToInt(netAddressInBytes);
    }

    private static int[] convertFromByteToInt(ArrayList<Byte> argument) {
        int[] result = new int[4];
        for (int i = 0; i < argument.size(); ++i) {
            result[i] = argument.get(i).intValue() & 0xFF;
        }

        return result;
    }

    private static void printNetAddress(int[] netAddress) {
        for (int i = 0; i < netAddress.length; ++i) {
            String str = Integer.toString(netAddress[i]);
            if (i < netAddress.length - 1)
            {
                str += ".";
            }

            System.out.print(str);
        }
    }
}
