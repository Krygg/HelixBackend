package com.company;


//todo a better name for this badboi

import terminals.TimeSignature;

public class Synth {
    private String note;
    private String synth;
    private int attack, decay, sustain, release;
    private double volume;
    private TimeSignature timeSignature;
    private int delayTime;

    public Synth(String note, String synth, int attack, int decay, int sustain, int release, double volume, TimeSignature timeSignature) {
        this.note = note;
        this.synth = synth;
        this.attack = attack;
        this.decay = decay;
        this.sustain = sustain;
        this.release = release;
        this.volume = volume;
        this.timeSignature = timeSignature;
    }

    public static class Builder {
        //Here we ajust standard values
        private String node = "c4";
        private int attack = 1, decay = 1, sustain = 1, release = 1;
        private double volume = 1;
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

        //TODO make sure, the synth is true.
        public Builder Synth(String synth) {
            this.synth = synth;
            return this;
        }

        public Builder Release(int release) {
            this.release = release;
            return this;
        }

        //Check if volume is between 0-1
        public Builder Volume(double volume) {
            if (volume > 0 && volume < 1) {
                this.volume = volume;
            } else {
                throw new IllegalArgumentException();
            }
            return this;
        }

        public Synth build() {
            Synth synth = new Synth();
            synth.attack = this.attack;
            synth.sustain = this.sustain;
            synth.decay = this.decay;
            synth.release = this.release;
            synth.synth = this.synth;
            synth.volume = this.volume;

            //Sender builder takes a chord and convertes it into a midi number, while building.
            synth.note = convertNodeToMidi(this.node);


            return synth;

        }


        //TODO make this pretty
        private String convertNodeToMidi(String node) {
            MidiLookUp midiLookUp = MidiLookUp.getInstance();
            node = node.replaceAll("\\s+", "");
            String[] strings = node.split(",");
            StringBuilder stringBuilder = new StringBuilder("");

            if (strings.length > 1) {
                for (int i = 0; i < strings.length - 1; i++) {
                    stringBuilder.append(midiLookUp.getMidiNumber(strings[i])).append(", ");
                }
                stringBuilder.append(midiLookUp.getMidiNumber(strings[strings.length - 1]));
            } else {
                stringBuilder.append(midiLookUp.getMidiNumber(strings[0]));
            }
            System.out.println(stringBuilder.toString());
            return stringBuilder.toString();
        }
    }

    private Synth() {
    }

    public String getNote() {
        return note;
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

    public int getDelayTime() {
        return delayTime;
    }

    public TimeSignature getTimeSignature() {
        return timeSignature;
    }

    public void setTimeSignature(TimeSignature timeSignature) {
        this.timeSignature = timeSignature;
    }

    public void setDelayTime(int delayTime) {
        this.delayTime = delayTime;
    }

    public String getSynth() {
        return synth;
    }

    public double getVolume() {
        return volume;
    }
}
