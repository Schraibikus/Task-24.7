
package org.example;
public enum StudyProfile{
    MEDICINE("Медицина"),
    CHEMISTRY("Химия"),
    BIOLOGY("Биология");

    private final String profileName;

    private StudyProfile (String profileName){
        this.profileName = profileName;
    }
    public String getProfileName(){
        return this.profileName;
    }


}
