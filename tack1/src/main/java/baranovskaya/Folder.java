package baranovskaya;

import java.util.HashMap;
import java.util.Map;

public class Folder extends Item {
    private Map<String, Item> items;

    public Folder(String name) {
        super(name);
        items = new HashMap<>();
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.put(item.getName(), item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString() + "/\n");
        for (Item item : items.values()) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }
}
