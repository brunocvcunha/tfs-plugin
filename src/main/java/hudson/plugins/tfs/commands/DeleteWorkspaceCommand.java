package hudson.plugins.tfs.commands;

import hudson.plugins.tfs.util.MaskedArgumentListBuilder;

public class DeleteWorkspaceCommand extends AbstractCommand {

    private final String workspaceName;

    public DeleteWorkspaceCommand(ServerConfigurationProvider provider, String workspaceName) {
        super(provider);
        this.workspaceName = workspaceName;
    }

    public MaskedArgumentListBuilder getArguments() {
        MaskedArgumentListBuilder arguments = new MaskedArgumentListBuilder();        
        arguments.add("workspace");
        arguments.add("-delete");
        arguments.add(String.format("%s;%s", workspaceName, getConfig().getUserName()));
        arguments.add("-noprompt");
        addServerArgument(arguments);
        addProxyArgument(arguments);
        addLoginArgument(arguments);
        return arguments;
    }
}
