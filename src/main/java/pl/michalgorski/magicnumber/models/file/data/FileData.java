package pl.michalgorski.magicnumber.models.file.data;

public class FileData {

    private String fileName;
    private String fileExtension;
    private boolean isFileExtensionSupported;
    private String realExtension;
    private boolean isRealExtensionSupported;

    public FileData(String fileName, String fileExtension, boolean isFileExtensionSupported, String realExtension,
                    boolean isRealExtensionSupported) {
        this.fileName = fileName;
        this.fileExtension = fileExtension;
        this.isFileExtensionSupported = isFileExtensionSupported;
        this.realExtension = realExtension;
        this.isRealExtensionSupported = isRealExtensionSupported;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public boolean isFileExtensionSupported() {
        return isFileExtensionSupported;
    }

    public String getRealExtension() {
        return realExtension;
    }

    public boolean isRealExtensionSupported() {
        return isRealExtensionSupported;
    }
}
