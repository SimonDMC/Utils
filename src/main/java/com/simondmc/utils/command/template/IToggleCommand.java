package com.simondmc.utils.command.template;

public interface IToggleCommand {
    String getToggleDisplayName();
    default Boolean isInverted() { return false; }
    default Boolean saysDefaultInsteadOfOff() { return false; }
}
