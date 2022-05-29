package com.simondmc.utils.command.template;

public interface ToggleCommand {
    String getToggleDisplayName();
    Boolean isInverted();
    Boolean saysDefaultInsteadOfOff();
}
