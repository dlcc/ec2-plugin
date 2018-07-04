
package hudson.plugins.ec2.util;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.*;
import com.amazonaws.AmazonClientException;

import java.util.*;

public class LaunchTemplateHelper {

    private List<LaunchTemplateVersion> templateVersions;

    public LaunchTemplateHelper(AmazonEC2 ec2, String launchTemplateName) throws AmazonClientException {
        DescribeLaunchTemplateVersionsRequest request = new DescribeLaunchTemplateVersionsRequest().withLaunchTemplateName(launchTemplateName);
        DescribeLaunchTemplateVersionsResult result = ec2.describeLaunchTemplateVersions(request);
        this.templateVersions = result.getLaunchTemplateVersions();
    }

    public String getID() {
        if (! templateVersions.isEmpty())
            return templateVersions.get(0).getLaunchTemplateId();
        else
            return null;
    }

    public LaunchTemplateVersion getLatest() {

        long latestVersionNumber=0;
        LaunchTemplateVersion latestVersion = null;

        for (LaunchTemplateVersion ltv : this.templateVersions)
            if (ltv.getVersionNumber() > latestVersionNumber) {
                latestVersion=ltv;
                latestVersionNumber = ltv.getVersionNumber();
            }
        return latestVersion;        

    }

    public LaunchTemplateVersion getDefault() {
        for (LaunchTemplateVersion ltv : this.templateVersions)
            if (ltv.isDefaultVersion()) {
                return ltv;
            }
        return null;
    }

    public LaunchTemplateVersion Version(Long version) {
        for (LaunchTemplateVersion ltv : this.templateVersions)
            if (ltv.getVersionNumber() == version) {
                return ltv;
            }
        return null;
    }

}