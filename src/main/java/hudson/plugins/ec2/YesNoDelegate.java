package hudson.plugins.ec2;

import hudson.model.*;

public enum YesNoDelegate {

    YES         (Messages.YesNoDelegate_Yes()),
    NO          (Messages.YesNoDelegate_No()),
    DELEGATE    (Messages.YesNoDelegate_Delegate());


    private final String value;

    YesNoDelegate(String value) {
        this.value=value;
    }

    public static YesNoDelegate fromBoolean(Boolean b) {
        if (b == true )
            return YesNoDelegate.YES;
        else
            return YesNoDelegate.NO;
    }

    public static boolean toBoolean(YesNoDelegate ynd) {
        if (ynd == YesNoDelegate.YES )
            return true;
        else
            return false;
    }

    public boolean toBoolean() {
        return toBoolean(this);
    }

    public boolean isNotDelegate() {
        return this != YesNoDelegate.DELEGATE;
    }

    public String getDescription() {
        return this.value;
    }
}