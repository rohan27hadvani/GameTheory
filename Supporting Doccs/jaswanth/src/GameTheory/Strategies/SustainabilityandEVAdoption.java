/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GameTheory.Strategies;

/**
 *
 * @author dintakurthinagasai
 */
public class SustainabilityandEVAdoption extends Strategy {
    public SustainabilityandEVAdoption() {
        super();
    }

    @Override
    public int makeMove(boolean player) {
        if(!player){
            return 4;
        }
        else{
            return 0;
        }
    }
}