package baranovskaya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FileSystemTest {
    @Test
    void add_ShouldAddFiles_WhenUsersEntersValue() {
        FileSystem fs = new FileSystem();
        fs.add("folder/file.txt");
        var expected = "root/\nfolder/\nfile.txt\n\n";
        Assertions.assertEquals(expected, fs.print());
    }

    @Test
    void print_ShouldDisplayInfo_WhenUsersEntersValue() {
        FileSystem fs = new FileSystem();
        fs.add("folder/file.txt");
        var expected = "root/\nfolder/\nfile.txt\n\n";
        Assertions.assertEquals(expected, fs.print());

    }

}