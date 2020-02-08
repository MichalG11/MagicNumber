package pl.michalgorski.magicnumber.models.file.service;

import pl.michalgorski.magicnumber.models.file.data.FileData;
import pl.michalgorski.magicnumber.models.file.data.FilePatternModel;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileDataFactory {

    private ByteReadService byteReadService;
    private RealExtensionService realExtensionService;
    private FileExtensionService fileExtensionService;
    private FilePatternModel filePatternModel;
    private final Map<String, int[]> mapWithFilePattern;

    public FileDataFactory() {
        byteReadService = new ByteReadService();
        realExtensionService = new RealExtensionService();
        fileExtensionService = new FileExtensionService();
        filePatternModel = new FilePatternModel();
        mapWithFilePattern = filePatternModel.getMapWithFilePattern();
    }

    /**
     * The method reads a File list and creates a FileData list.
     *
     * @param listWithFiles
     * @return
     * @throws IOException
     */
    public List<FileData> createFileDataList(List<File> listWithFiles) throws IOException {

        List<FileData> listWithFileData = new ArrayList<>();

        for (File oneFile : listWithFiles) {
            FileData fileData = createFileData(oneFile);
            listWithFileData.add(fileData);
        }
        return listWithFileData;
    }

    private FileData createFileData(File file) throws IOException {

        String fileName = file.getName();
        String fileExtension = fileExtensionService.getExtensionOfFile(file);
        boolean isFileExtensionSupported = isFileExtensionSupported(fileExtension);
        byte[] realByteArray = byteReadService.getBytesOfFile(file);

        String realExtension = realExtensionService.getRealExtension(realByteArray).isEmpty()
                                ? realExtensionService.getRealExtensionForTxtFile(realByteArray)
                                : realExtensionService.getRealExtension(realByteArray);

        boolean isRealExtensionSupported = !realExtension.isEmpty();

        return new FileData(fileName, fileExtension, isFileExtensionSupported, realExtension, isRealExtensionSupported);
    }

    private boolean isFileExtensionSupported(String fileExtension) {

        return mapWithFilePattern.containsKey(fileExtension);
    }
}