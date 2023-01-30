package org.aquarium;
public class ToggleEntityVisibility implements Command{

    Toggle toggle;

    public ToggleEntityVisibility(Toggle toggle){
        this.toggle = toggle;
    }



    @Override
    public void execute() {
        toggle.ToggleEntity();
        
    }

    @Override
    public void undo() {
        toggle.UnToggleEntity();
        
    }
}
