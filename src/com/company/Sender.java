package com.company;



//todo a better name for this badboi

public class Sender {
    private int node;
    private String synth;
    private int attack, decay,sustain,release;

    public static class Builder{
        //Here we ajust standard values
        private String node = "c4";
        private int attack=1, decay=1,sustain=1,release=1;
        private String synth = "piano";

        public Builder() {
        }

        public Builder Node(String node) {
            this.node = node;
            return this;
        }

        public Builder Attack(int attack) {
            this.attack = attack;
            return this;
        }

        public Builder Decay(int decay) {
            this.decay = decay;
            return this;
        }

        public Builder Sustain(int sustain) {
            this.sustain = sustain;
            return this;
        }

        public Builder Synth(String synth) {
            this.synth = synth;
            return this;
        }

        public Builder Release(int release) {
            this.release = release;
            return this;
        }
        public Sender build() {
            Sender sender = new Sender();
            sender.attack = this.attack;
            sender.sustain = this.sustain;
            sender.decay = this.decay;
            sender.release = this.release;
            sender.synth = this.synth;


            //Sender builder takes a chord and convertes it into a midi number, while building.
            MidiLookUp midiLookUp = MidiLookUp.getInstance();
            sender.node = midiLookUp.getMidiNumber(this.node);

            return sender;

        }
    }

    private Sender() {
    }

    public int getNode() {
        return node;
    }

    public int getAttack() {
        return attack;
    }

    public int getDecay() {
        return decay;
    }

    public int getSustain() {
        return sustain;
    }

    public int getRelease() {
        return release;
    }

    public String getSynth() {
        return synth;
    }
}
