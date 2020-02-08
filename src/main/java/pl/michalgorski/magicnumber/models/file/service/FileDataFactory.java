package pl.michalgorski.magicnumber.models.file.service;

import pl.michalgorski.magicnumber.models.file.data.FileData;
import pl.michalgorski.magicnumber.models.file.data.FilePatternModel;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileDataFactory {

    private ByteReadService byteReadService;
    private FileExtensionService fileExtensionService;
    private FilePatternModel filePatternModel;
    private final Map<String, int[]> mapWithFilePattern;

    public FileDataFactory() {
        byteReadService = new ByteReadService();
        fileExtensionService = new FileExtensionService();
        filePatternModel = new FilePatternModel();
        mapWithFilePattern = filePatternModel.getMapWithFilePattern();
    }

    public List<FileData> createFileDataList(List<File> list) throws IOException {

        List<FileData> listOfFileData = new ArrayList<>();

        for (File oneFile : list) {
            FileData fileData = createFileData(oneFile);
            listOfFileData.add(fileData);
        }
        return listOfFileData;
    }

    private FileData createFileData(File file) throws IOException {

        String fileName = file.getName();
        String fileExtension = fileExtensionService.getExtensionOfFile(file);
        boolean isFileExtensionSupported = isFileExtensionSupported(fileExtension);
        byte[] realByteArray = byteReadService.getBytesOfFile(file);

        String realExtension = getRealExtension(realByteArray).isEmpty() ? getRealExtensionForTxtFile(realByteArray)
                : getRealExtension(realByteArray);

        boolean isRealExtensionSupported = !realExtension.isEmpty();

        return new FileData(fileName, fileExtension, isFileExtensionSupported, realExtension, isRealExtensionSupported);
    }

    private boolean isFileExtensionSupported(String fileExtension) {

        return mapWithFilePattern.containsKey(fileExtension);
    }

    private String getRealExtension(byte[] byteArray) {

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

    private String getRealExtensionForTxtFile(byte[] byteArray) {

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