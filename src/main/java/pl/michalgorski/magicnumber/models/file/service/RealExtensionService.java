package pl.michalgorski.magicnumber.models.file.service;

import pl.michalgorski.magicnumber.models.file.data.FilePatternModel;

import java.util.Arrays;
import java.util.Map;

class RealExtensionService {

    private FilePatternModel filePatternModel;
    private final Map<String, int[]> mapWithFilePattern;

    RealExtensionService() {
        filePatternModel = new FilePatternModel();
        mapWithFilePattern = filePatternModel.getMapWithFilePattern();
    }

    String getRealExtension(byte[] byteArray) {

        String realExtension = "";

        if (byteArray.length > 0) {
            int lengthOfPatternArray = 3;
            int[] realIntArray = new int[lengthOfPatternArray];

            for (int i = 0; i < lengthOfPatternArray; i++) {
                realIntArray[i] = Byte.toUnsignedInt(byteArray[i]);
            }
            for (Map.Entry<String, int[]> entry : mapWithFilePattern.entrySet()) {

                if (Arrays.equals(realIntArray, entry.getValue())) {
                    realExtension = entry.getKey();
                    break;
                }
            }
        }
        return realExtension;
    }

    String getRealExtensionForTxtFile(byte[] byteArray) {

        String realExtension = "TXT";
        int currentIntValue;
        if (byteArray.length > 0) {
            for (byte currentByteValue : byteArray) {
                currentIntValue = Byte.toUnsignedInt(currentByteValue);

                if (currentIntValue < 32 || currentIntValue > 127) {
                    realExtension = "";
                    break;
                }
            }
        }
        return realExtension;
    }
}
