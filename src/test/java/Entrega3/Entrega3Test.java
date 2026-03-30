package Entrega3;

import Entrega3.adapter.ArCondicionado.ArVentoBaumnAdapter;
import Entrega3.adapter.Lampada.*;
import Entrega3.adapter.Persiana.PersianaSolariusAdapter;
import Entrega3.domain.device.*;
import Entrega3.facade.CasaInteligente;
import br.furb.analise.algoritmos.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega3Test {
    @Test
    void deveLigarLampada() {

        LampadaPhelippesAdapter lampada =
                new LampadaPhelippesAdapter(new LampadaPhellipes());

        lampada.ligar();

        assertEquals(true, lampada.isLigada());
    }

    @Test
    void deveDesligarLampada() {

        LampadaShoyouMiAdapter lampada =
                new LampadaShoyouMiAdapter(new LampadaShoyuMi());

        lampada.ligar();
        lampada.desligar();

        assertEquals(false, lampada.isLigada());
    }

    @Test
    void deveDefinirTemperatura() {

        ArVentoBaumnAdapter ar =
                new ArVentoBaumnAdapter(new ArCondicionadoVentoBaumn());

        ar.ligar();
        ar.definirTemperatura(25);

        assertEquals(25, ar.getTemperatura());
    }

    @Test
    void deveAtivarModoTrabalho() {

        Lampada lampada = new LampadaPhelippesAdapter(new LampadaPhellipes());
        Persiana persiana = new PersianaSolariusAdapter(new PersianaSolarius());
        ArCondicionado ar = new ArVentoBaumnAdapter(new ArCondicionadoVentoBaumn());

        CasaInteligente casa = new CasaInteligente(
                List.of(lampada),
                List.of(persiana),
                List.of(ar)
        );

        casa.modoTrabalho();

        assertEquals(true, lampada.isLigada());
        assertEquals(true, ar.isLigado());
        assertEquals(25, ar.getTemperatura());
    }

    @Test
    void deveAtivarModoSono() {

        LampadaPhelippesAdapter lampada =
                new LampadaPhelippesAdapter(new LampadaPhellipes());

        ArVentoBaumnAdapter ar =
                new ArVentoBaumnAdapter(new ArCondicionadoVentoBaumn());

        PersianaSolariusAdapter persiana =
                new PersianaSolariusAdapter(new PersianaSolarius());

        CasaInteligente casa = new CasaInteligente(
                List.of(lampada),
                List.of(persiana),
                List.of(ar)
        );

        casa.modoSono();

        assertEquals(false, lampada.isLigada());
        assertEquals(false, ar.isLigado());
    }

    @Test
    void deveLigarEdesligarAr() {

        ArVentoBaumnAdapter ar =
                new ArVentoBaumnAdapter(new ArCondicionadoVentoBaumn());

        ar.ligar();
        assertTrue(ar.isLigado());

        ar.desligar();
        assertFalse(ar.isLigado());
    }

    @Test
    void deveAumentarEDiminuirTemperatura() {

        ArVentoBaumnAdapter ar =
                new ArVentoBaumnAdapter(new ArCondicionadoVentoBaumn());

        ar.ligar();

        ar.aumentarTemperatura();
        ar.aumentarTemperatura();

        assertEquals(26, ar.getTemperatura());

        ar.diminuirTemperatura();

        assertEquals(25, ar.getTemperatura());
    }

    @Test
    void deveAbrirEFecharPersiana() {

        PersianaSolariusAdapter persiana =
                new PersianaSolariusAdapter(new PersianaSolarius());

        persiana.abrir();
        assertTrue(persiana.isAberta());

        persiana.fechar();
        assertFalse(persiana.isAberta());
    }

    @Test
    void deveControlarMultiplosDispositivos() {

        Lampada lampada1 = new LampadaPhelippesAdapter(new LampadaPhellipes());
        Lampada lampada2 = new LampadaShoyouMiAdapter(new LampadaShoyuMi());

        ArCondicionado ar1 = new ArVentoBaumnAdapter(new ArCondicionadoVentoBaumn());

        Persiana persiana1 = new PersianaSolariusAdapter(new PersianaSolarius());

        CasaInteligente casa = new CasaInteligente(
                List.of(lampada1, lampada2),
                List.of(persiana1),
                List.of(ar1)
        );

        casa.modoTrabalho();

        assertTrue(lampada1.isLigada());
        assertTrue(lampada2.isLigada());
        assertTrue(ar1.isLigado());
    }
}
