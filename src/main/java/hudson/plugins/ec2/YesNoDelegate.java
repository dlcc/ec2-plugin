package hudson.plugins.ec2;

import hudson.model.*;

public enum YesNoDelegate {

    YES         (Messages.YesNoDelegate_Yes()()),
    NO          (Messages.YesNoDelegate_No()),
    DELEGATE    (Messages.YesNoDelegate_Delegate());


    private final String value;

    YesNoDelegate(String value) {
        this.value=value;
    }

    public boolean toBoolean() {
        if (this == YesNoDelegate.YES )
            return true;
        else
            return false;
    }

    public String getDescription() {
        return this.value;
    }
}