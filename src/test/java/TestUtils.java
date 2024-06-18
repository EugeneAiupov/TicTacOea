import java.awt.Component;
import java.awt.Container;

public class TestUtils {
    public static Component getChildComponent(Container parent, Class<?> cls) {
        for (Component comp : parent.getComponents()) {
            if (cls.isInstance(comp)) {
                return comp;
            } else if (comp instanceof Container) {
                Component child = getChildComponent((Container) comp, cls);
                if (child != null) {
                    return child;
                }
            }
        }
        return null;
    }
}
