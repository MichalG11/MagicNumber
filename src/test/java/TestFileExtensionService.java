import org.junit.jupiter.api.BeforeEach;
import pl.michalgorski.magicnumber.models.file.service.FileExtensionService;

public class TestFileExtensionService {

    private static FileExtensionService fileExtensionService;

    @BeforeEach
    void beforeClass() {
        fileExtensionService = new FileExtensionService();
    }

}
