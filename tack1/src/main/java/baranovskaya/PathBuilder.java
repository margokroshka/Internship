package baranovskaya;



public class PathBuilder {
    @org.jetbrains.annotations.Contract(pure = true)
    private PathBuilder() {
    }

    public static Folder processInput(String input, Folder root) {
            String[] parts = input.split("/");
            Folder currentFolder = root;
            for (int i = 0; i < parts.length - 1; i++) {
                if (!currentFolder.getItems().containsKey(parts[i])) {
                    Folder newFolder = new Folder(parts[i]);
                    currentFolder.addItem(newFolder);
                }
                currentFolder = (Folder) currentFolder.getItems().get(parts[i]);
            }
                String[] fileParts = parts[parts.length - 1].split("\\.");
                File file = new File(fileParts[0], fileParts[1]);
                currentFolder.addItem(file);

            return root;
    }
}
