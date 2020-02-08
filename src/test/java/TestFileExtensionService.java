import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.michalgorski.magicnumber.models.file.service.FileExtensionService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TestFileExtensionService {

    private static FileExtensionService fileExtensionService;

    @BeforeEach
    void beforeClass() {
        fileExtensionService = new FileExtensionService();
    }

    @BeforeEach
    @Test
    void test01CutExtension() {

        try{
            Method cutExtensionFromFileName = FileExtensionService.class.getDeclaredMethod("cutExtensionFromFileName",
                    String.class);
            cutExtensionFromFileName.setAccessible(true);
            String output = (String) cutExtensionFromFileName.invoke(fileExtensionService, "file.TXT");
            Assertions.assertEquals("TXT", output);

        } catch (SecurityException | NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }

    @BeforeEach
    @Test
    void test02CutExtension() {

        try{
            Method cutExtensionFromFileName = FileExtensionService.class.getDeclaredMethod("cutExtensionFromFileName",
                    String.class);
            cutExtensionFromFileName.setAccessible(true);
            String output = (String) cutExtensionFromFileName.invoke(fileExtensionService, "file.txt.jpg.docx");
            Assertions.assertEquals("DOCX", output);

        } catch (SecurityException | NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }

    @BeforeEach
    @Test
    void test03CutExtension() {

        try{
            Method cutExtensionFromFileName = FileExtensionService.class.getDeclaredMethod("cutExtensionFromFileName",
                    String.class);
            cutExtensionFromFileName.setAccessible(true);
            String output = (String) cutExtensionFromFileName.invoke(fileExtensionService, "FILEtxt");
            Assertions.assertEquals("", output);

        } catch (SecurityException | NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
}
