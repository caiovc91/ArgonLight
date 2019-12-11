package caio.systems.argonlight;

import android.media.Image;

import androidx.annotation.NonNull;

public class MessagesClass {
    private int msgIcon;
    private String msgTitle;

    public MessagesClass(int msgIcon, String msgTitle) {
        this.msgIcon = msgIcon;
        this.msgTitle = msgTitle;
    }

    public int getMsgIcon() {
        return msgIcon;
    }

    public void setMsgIcon(int msgIcon) {
        this.msgIcon = msgIcon;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String toString() {
        return this.msgTitle;
    }
}
