import javax.swing.*;
import java.awt.event.KeyEvent;

public class JNumberField extends JTextField {
    private static final long serialVersionUID = 1L;

    @Override
    public void processKeyEvent(KeyEvent ev) {
        if (Character.isDigit(ev.getKeyChar()) || ev.getKeyChar() == '\u0008' || ev.getKeyChar() == '\u007f') {
            super.processKeyEvent(ev);
        }
        ev.consume();
        return;
    }

    /**
     * As the user is not even able to enter a dot ("."), only integers (whole numbers) may be entered.
     */
    public int getNumber() {
        Integer result = null;
        String text = getText();
        if (text != null && !"".equals(text)) {
            result = Integer.valueOf(text);
        }
        return result;
    }
}
