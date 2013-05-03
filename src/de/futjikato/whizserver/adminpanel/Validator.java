package de.futjikato.whizserver.adminpanel;

/**
 * @author moritzspindelhirn
 * @todo Documentation
 * @category de.futjikato.whizserver.adminpanel
 */
public interface Validator {
    public String filter(String input);
    public boolean validate(String input);
}
