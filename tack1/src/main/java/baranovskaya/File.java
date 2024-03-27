package baranovskaya;

public class File extends Item {
    private String extension;

    public File(String name, String extension) {
        super(name);
        this.extension = extension;
    }

    @Override
    public String toString() {
        return super.toString() + "." + extension;
    }
}
