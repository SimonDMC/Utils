package com.simondmc.utils.command.template;

public interface IToggleCommand {
    String getToggleDisplayName();
    Boolean isInverted();
    Boolean saysDefaultInsteadOfOff();
}
