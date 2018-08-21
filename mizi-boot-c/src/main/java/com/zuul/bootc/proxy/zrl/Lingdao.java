package com.zuul.bootc.proxy.zrl;

public abstract class Lingdao {
    private Lingdao lingdao;

    public Lingdao getNextLingdao() {
        return lingdao;
    }

    public void setNextLingdao(Lingdao lingdao) {
        this.lingdao = lingdao;
    }



     abstract void chuli(Files file);
}
