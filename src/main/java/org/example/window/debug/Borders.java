package org.example.window.debug;

import org.example.Main;
import org.example.window.components.Button;
import org.example.window.components.CheckBox;
import org.example.window.components.Label;
import org.example.window.components.Panel;
import org.example.window.components.PasswordField;
import org.example.window.components.TextField;

public class Borders {

    public Borders() {
    }

    public CheckBox get() {
        CheckBox borders = new CheckBox("borders", "borders", 1, 25, 125, 20, false, e -> {
            Main.bordered = !Main.isBordered();
            Main.windows.forEach(it -> {
                it.getComponentList().forEach(obj -> {
                    if (obj instanceof Button) { ((Button) obj).updateBorders(); }
                    if (obj instanceof CheckBox) { ((CheckBox) obj).updateBorders(); }
                    if (obj instanceof Label) { ((Label) obj).updateBorders(); }
                    if (obj instanceof Panel) { ((Panel) obj).updateBorders(); }
                    if (obj instanceof PasswordField) { ((PasswordField) obj).updateBorders(); }
                    if (obj instanceof TextField) { ((TextField) obj).updateBorders(); }
                });
            });
        });
        borders.setBorder(null);
        borders.setSelected(false);
        return borders;
    }

}
