package com.vincenzoemanuele.code4code.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

public class Form {

    public Form(){

    }

    public Form(boolean assembly, boolean bash, boolean batch, boolean CSharp, boolean cpp, boolean c, boolean CSS, boolean go, boolean groovy, boolean hack, boolean HTML, boolean java, boolean javaScript, boolean kotlin, boolean lua, boolean objectiveC, boolean perl, boolean PHP, boolean powerShell, boolean python, boolean ruby, boolean SQL, boolean swift, boolean teX, boolean typeScript) {
        Assembly = assembly;
        Bash = bash;
        Batch = batch;
        this.CSharp = CSharp;
        Cpp = cpp;
        C = c;
        this.CSS = CSS;
        Go = go;
        Groovy = groovy;
        Hack = hack;
        this.HTML = HTML;
        Java = java;
        JavaScript = javaScript;
        Kotlin = kotlin;
        Lua = lua;
        ObjectiveC = objectiveC;
        Perl = perl;
        this.PHP = PHP;
        PowerShell = powerShell;
        Python = python;
        Ruby = ruby;
        this.SQL = SQL;
        Swift = swift;
        TeX = teX;
        TypeScript = typeScript;
    }

    public boolean isAssembly() {
        return Assembly;
    }

    public void setAssembly(boolean assembly) {
        Assembly = assembly;
    }

    public boolean isBash() {
        return Bash;
    }

    public void setBash(boolean bash) {
        Bash = bash;
    }

    public boolean isBatch() {
        return Batch;
    }

    public void setBatch(boolean batch) {
        Batch = batch;
    }

    public boolean isCSharp() {
        return CSharp;
    }

    public void setCSharp(boolean CSharp) {
        this.CSharp = CSharp;
    }

    public boolean isCpp() {
        return Cpp;
    }

    public void setCpp(boolean cpp) {
        Cpp = cpp;
    }

    public boolean isC() {
        return C;
    }

    public void setC(boolean c) {
        C = c;
    }

    public boolean isCSS() {
        return CSS;
    }

    public void setCSS(boolean CSS) {
        this.CSS = CSS;
    }

    public boolean isGo() {
        return Go;
    }

    public void setGo(boolean go) {
        Go = go;
    }

    public boolean isGroovy() {
        return Groovy;
    }

    public void setGroovy(boolean groovy) {
        Groovy = groovy;
    }

    public boolean isHack() {
        return Hack;
    }

    public void setHack(boolean hack) {
        Hack = hack;
    }

    public boolean isHTML() {
        return HTML;
    }

    public void setHTML(boolean HTML) {
        this.HTML = HTML;
    }

    public boolean isJava() {
        return Java;
    }

    public void setJava(boolean java) {
        Java = java;
    }

    public boolean isJavaScript() {
        return JavaScript;
    }

    public void setJavaScript(boolean javaScript) {
        JavaScript = javaScript;
    }

    public boolean isKotlin() {
        return Kotlin;
    }

    public void setKotlin(boolean kotlin) {
        Kotlin = kotlin;
    }

    public boolean isLua() {
        return Lua;
    }

    public void setLua(boolean lua) {
        Lua = lua;
    }

    public boolean isObjectiveC() {
        return ObjectiveC;
    }

    public void setObjectiveC(boolean objectiveC) {
        ObjectiveC = objectiveC;
    }

    public boolean isPerl() {
        return Perl;
    }

    public void setPerl(boolean perl) {
        Perl = perl;
    }

    public boolean isPHP() {
        return PHP;
    }

    public void setPHP(boolean PHP) {
        this.PHP = PHP;
    }

    public boolean isPowerShell() {
        return PowerShell;
    }

    public void setPowerShell(boolean powerShell) {
        PowerShell = powerShell;
    }

    public boolean isPython() {
        return Python;
    }

    public void setPython(boolean python) {
        Python = python;
    }

    public boolean isRuby() {
        return Ruby;
    }

    public void setRuby(boolean ruby) {
        Ruby = ruby;
    }

    public boolean isSQL() {
        return SQL;
    }

    public void setSQL(boolean SQL) {
        this.SQL = SQL;
    }

    public boolean isSwift() {
        return Swift;
    }

    public void setSwift(boolean swift) {
        Swift = swift;
    }

    public boolean isTeX() {
        return TeX;
    }

    public void setTeX(boolean teX) {
        TeX = teX;
    }

    public boolean isTypeScript() {
        return TypeScript;
    }

    public void setTypeScript(boolean typeScript) {
        TypeScript = typeScript;
    }

    @Override
    public String toString() {
        return "Form{" +
                "Assembly=" + Assembly +
                ", Bash=" + Bash +
                ", Batch=" + Batch +
                ", CSharp=" + CSharp +
                ", Cpp=" + Cpp +
                ", C=" + C +
                ", CSS=" + CSS +
                ", Go=" + Go +
                ", Groovy=" + Groovy +
                ", Hack=" + Hack +
                ", HTML=" + HTML +
                ", Java=" + Java +
                ", JavaScript=" + JavaScript +
                ", Kotlin=" + Kotlin +
                ", Lua=" + Lua +
                ", ObjectiveC=" + ObjectiveC +
                ", Perl=" + Perl +
                ", PHP=" + PHP +
                ", PowerShell=" + PowerShell +
                ", Python=" + Python +
                ", Ruby=" + Ruby +
                ", SQL=" + SQL +
                ", Swift=" + Swift +
                ", TeX=" + TeX +
                ", TypeScript=" + TypeScript +
                '}';
    }

    public boolean Assembly;
    public boolean Bash;
    public boolean Batch;
    public boolean CSharp;
    public boolean Cpp;
    public boolean C;
    public boolean CSS;
    public boolean Go;
    public boolean Groovy;
    public boolean Hack;
    public boolean HTML;
    public boolean Java;
    public boolean JavaScript;
    public boolean Kotlin;
    public boolean Lua;
    public boolean ObjectiveC;
    public boolean Perl;
    public boolean PHP;
    public boolean PowerShell;
    public boolean Python;
    public boolean Ruby;
    public boolean SQL;
    public boolean Swift;
    public boolean TeX;
    public boolean TypeScript;

}
