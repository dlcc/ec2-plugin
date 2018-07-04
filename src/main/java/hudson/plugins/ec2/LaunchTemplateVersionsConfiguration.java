package hudson.plugins.ec2;

import org.kohsuke.stapler.DataBoundConstructor;

public final class LaunchTemplateVersionsConfiguration {
    public final String launchTemplateVersion;

    @DataBoundConstructor
    public LaunchTemplateVersionsConfiguration(String launchTemplateVersion) {
        this.launchTemplateVersion = launchTemplateVersion;
    }

    public String getLaunchTemplateVersion() {
        return launchTemplateVersion;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (this.getClass() != obj.getClass())) {
            return false;
        }
        final LaunchTemplateVersionsConfiguration config = (LaunchTemplateVersionsConfiguration) obj;

        return (this.launchTemplateVersion).equals((config.launchTemplateVersion));
    }
}
