package hudson.plugins.ec2;

import org.kohsuke.stapler.DataBoundConstructor;
import com.amazonaws.services.ec2.model.InstanceType;

public final class TypeConfiguration {
    public final InstanceType type;

    @DataBoundConstructor
    public TypeConfiguration(InstanceType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (this.getClass() != obj.getClass())) {
            return false;
        }
        return this.type.equals(obj);
    }
}
