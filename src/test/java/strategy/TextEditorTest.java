package strategy;

import org.junit.Test;

public class TextEditorTest {
    @Test
    public void simpleStrategyPattern() {
        TextEditor.publishText("DEBUG - I'm here", TextUtil::acceptAll, TextUtil::noFormatting);
        TextEditor.publishText("ERROR - something bad happened", TextUtil::acceptErrors, TextUtil::formatError);
    }
}
