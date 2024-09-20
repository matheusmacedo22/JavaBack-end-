package controller;
import model.*;
import view.*;
import java.util.*;

public class DespertadorController extends DespertadorView {
    public static String[] verOpcoes() {
        return DespertadorModel.mostrarOpcoes();
    }

    public static void acaoDespertador(int opcaoUsuario) {
        if (adiamentoAtual < 3) {
            switch (opcaoUsuario) {
                case 1:
                    if (mostrarOpcoesAdiamentos()) {
                        if ((minutoAtual + adiar) > 59) {
                            horaDespertar++;
                            if (horaDespertar > 23) {
                                horaDespertar = 0;
                            }
                            minutoDespertar = (minutoAtual + adiar) - 59;
                        } else {
                            minutoDespertar = minutoAtual + adiar;
                        }
                        adiamentoAtual++;
                        exibirAlarmeAdiado(adiar);
                    } else {
                        break;
                    }
                    break;

                case 2:
                    sairDoSistema();
                    break;

                case 3: 
                    configurarDespertador();
                    System.out.println("Novo alarme configurado para " + horaDespertar + ":" + minutoDespertar);
                    break;

                default:
                    mostrarOpcaoInvalida();
                    break;
            }
        } else {
            sairDoSistema();
        }
    }

    public static void getHMS() {
        date = new Date();
        calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        horaAtual = calendar.get(Calendar.HOUR_OF_DAY);
        minutoAtual = calendar.get(Calendar.MINUTE);
        segundoAtual = calendar.get(Calendar.SECOND);

        if (horaDespertar > 0 && minutoDespertar > 0) {

            int[] tempoInicial = {horaAtual, minutoAtual, segundoAtual};
            int[] tempoFinal = {horaDespertar, minutoDespertar, 60};

            int[] tempoRestante = calcularTempoRestante(tempoInicial, tempoFinal);

            horaRestante = tempoRestante[0];
            minutoRestante = tempoRestante[1];
            segundoRestante = tempoRestante[2];
        }
    }

    public static int[] calcularTempoRestante(int[] tempoInicial, int[] tempoFinal) {
        int maxHoras = 24;
        int maxMinutos = 60;
        int maxSegundos = 60;

        int totalHorasPorDia = maxHoras;
        int totalMinutosPorDia = totalHorasPorDia * maxMinutos;
        int totalSegundosPorDia = totalMinutosPorDia * maxSegundos;

        int[] tempoRestante = {0,0,0}; 

        tempoRestante[0] = tempoFinal[0] - tempoInicial[0]; 
        tempoRestante[1] = (tempoFinal[1] - tempoInicial[1]) - 1; 
        tempoRestante[2] = tempoFinal[2] - tempoInicial[2]; 

        if (tempoRestante[0] > 0 && tempoFinal[1] <= tempoInicial[1]) {
            tempoRestante[0]--;
        }

        if (tempoRestante[1] < 0) {
            tempoRestante[1] = ((maxMinutos - tempoInicial[1]) + tempoFinal[1]) - 1;
        }


        if (tempoRestante[2] > maxSegundos) {
            tempoRestante[2] = maxSegundos;
        }

        return tempoRestante;
    }
}