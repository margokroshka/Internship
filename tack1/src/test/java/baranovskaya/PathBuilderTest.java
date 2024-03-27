package baranovskaya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PathBuilderTest {

    @Test
    void processInput_ShouldReturnStructure_WhenAddFolderWithFile() {
        var input = "folder/file.txt";
        var root = new Folder("root");

        var expected = "root/\nfolder/\nfile.txt\n\n";

        Assertions.assertEquals(expected, PathBuilder.processInput(input, root).toString());
    }

}