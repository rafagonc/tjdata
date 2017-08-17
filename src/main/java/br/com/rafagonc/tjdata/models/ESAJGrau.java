package br.com.rafagonc.tjdata.models;

/**
 * Created by rafagonc on 18/06/17.
 */
public enum ESAJGrau {
        Primeiro("cpopg",1),
        Segundo("cposg",2);

        public String parameter;
        private Integer value;

        ESAJGrau(String parameter, Integer value) {
            this.value =  value;
            this.parameter = parameter;
        }

        public String getParameter() {
                return parameter;
        }

        public Integer getValue() {
                return value;
        }

        public static ESAJGrau grauForValue(Integer i) {
            for (ESAJGrau grau : values()) {
                if (grau.getValue() == i) {
                    return grau;
                }
            }
            return ESAJGrau.Primeiro;
        }
}
