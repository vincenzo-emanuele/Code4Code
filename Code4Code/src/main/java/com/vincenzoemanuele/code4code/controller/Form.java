package com.vincenzoemanuele.code4code.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

public class Form {

    public Form() {
    }

    public Form(boolean assembly, boolean bash, boolean batch, boolean CSharp, boolean cpp, boolean c, boolean CSS, boolean go, boolean groovy, boolean hack, boolean HTML, boolean java, boolean javaScript, boolean kotlin, boolean lua, boolean objectiveC, boolean perl, boolean PHP, boolean powerShell, boolean python, boolean ruby, boolean SQL, boolean swift, boolean teX, boolean typeScript, boolean coffeeScript, boolean DOTNET, boolean AJAX, boolean amp, boolean android, boolean angular, boolean ASPDOTNET, boolean bootstrap, boolean django, boolean electron, boolean ember, boolean express, boolean firebase, boolean flask, boolean jQuery, boolean keras, boolean koa, boolean node, boolean rubyOnRails, boolean ratchet, boolean react, boolean reactNative, boolean reactiveUI, boolean scikit, boolean spring, boolean symfony, boolean tensorFlow, boolean vue) {
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
        CoffeeScript = coffeeScript;
        this.DOTNET = DOTNET;
        this.AJAX = AJAX;
        Amp = amp;
        Android = android;
        Angular = angular;
        this.ASPDOTNET = ASPDOTNET;
        Bootstrap = bootstrap;
        Django = django;
        Electron = electron;
        Ember = ember;
        Express = express;
        Firebase = firebase;
        Flask = flask;
        this.jQuery = jQuery;
        Keras = keras;
        Koa = koa;
        Node = node;
        RubyOnRails = rubyOnRails;
        Ratchet = ratchet;
        React = react;
        ReactNative = reactNative;
        ReactiveUI = reactiveUI;
        Scikit = scikit;
        Spring = spring;
        Symfony = symfony;
        TensorFlow = tensorFlow;
        Vue = vue;
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

    public boolean isCoffeeScript() {
        return CoffeeScript;
    }

    public void setCoffeeScript(boolean coffeeScript) {
        CoffeeScript = coffeeScript;
    }

    public boolean isDOTNET() {
        return DOTNET;
    }

    public void setDOTNET(boolean DOTNET) {
        this.DOTNET = DOTNET;
    }

    public boolean isAJAX() {
        return AJAX;
    }

    public void setAJAX(boolean AJAX) {
        this.AJAX = AJAX;
    }

    public boolean isAmp() {
        return Amp;
    }

    public void setAmp(boolean amp) {
        Amp = amp;
    }

    public boolean isAndroid() {
        return Android;
    }

    public void setAndroid(boolean android) {
        Android = android;
    }

    public boolean isAngular() {
        return Angular;
    }

    public void setAngular(boolean angular) {
        Angular = angular;
    }

    public boolean isASPDOTNET() {
        return ASPDOTNET;
    }

    public void setASPDOTNET(boolean ASPDOTNET) {
        this.ASPDOTNET = ASPDOTNET;
    }

    public boolean isBootstrap() {
        return Bootstrap;
    }

    public void setBootstrap(boolean bootstrap) {
        Bootstrap = bootstrap;
    }

    public boolean isDjango() {
        return Django;
    }

    public void setDjango(boolean django) {
        Django = django;
    }

    public boolean isElectron() {
        return Electron;
    }

    public void setElectron(boolean electron) {
        Electron = electron;
    }

    public boolean isEmber() {
        return Ember;
    }

    public void setEmber(boolean ember) {
        Ember = ember;
    }

    public boolean isExpress() {
        return Express;
    }

    public void setExpress(boolean express) {
        Express = express;
    }

    public boolean isFirebase() {
        return Firebase;
    }

    public void setFirebase(boolean firebase) {
        Firebase = firebase;
    }

    public boolean isFlask() {
        return Flask;
    }

    public void setFlask(boolean flask) {
        Flask = flask;
    }

    public boolean isjQuery() {
        return jQuery;
    }

    public void setjQuery(boolean jQuery) {
        this.jQuery = jQuery;
    }

    public boolean isKoa() {
        return Koa;
    }

    public void setKoa(boolean koa) {
        Koa = koa;
    }

    public boolean isNode() {
        return Node;
    }

    public void setNode(boolean node) {
        Node = node;
    }

    public boolean isRubyOnRails() {
        return RubyOnRails;
    }

    public void setRubyOnRails(boolean rubyOnRails) {
        RubyOnRails = rubyOnRails;
    }

    public boolean isRatchet() {
        return Ratchet;
    }

    public void setRatchet(boolean ratchet) {
        Ratchet = ratchet;
    }

    public boolean isReact() {
        return React;
    }

    public void setReact(boolean react) {
        React = react;
    }

    public boolean isReactNative() {
        return ReactNative;
    }

    public void setReactNative(boolean reactNative) {
        ReactNative = reactNative;
    }

    public boolean isReactiveUI() {
        return ReactiveUI;
    }

    public void setReactiveUI(boolean reactiveUI) {
        ReactiveUI = reactiveUI;
    }

    public boolean isScikit() {
        return Scikit;
    }

    public void setScikit(boolean scikit) {
        Scikit = scikit;
    }

    public boolean isSpring() {
        return Spring;
    }

    public void setSpring(boolean spring) {
        Spring = spring;
    }

    public boolean isSymfony() {
        return Symfony;
    }

    public void setSymfony(boolean symfony) {
        Symfony = symfony;
    }

    public boolean isTensorFlow() {
        return TensorFlow;
    }

    public void setTensorFlow(boolean tensorFlow) {
        TensorFlow = tensorFlow;
    }

    public boolean isVue() {
        return Vue;
    }

    public void setVue(boolean vue) {
        Vue = vue;
    }

    public boolean isKeras() {
        return Keras;
    }

    public void setKeras(boolean keras) {
        Keras = keras;
    }

    public boolean isThymeleaf() {
        return Thymeleaf;
    }

    public void setThymeleaf(boolean thymeleaf) {
        Thymeleaf = thymeleaf;
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
    public boolean CoffeeScript;
    public boolean DOTNET;
    public boolean AJAX;
    public boolean Amp;
    public boolean Android;
    public boolean Angular;
    public boolean ASPDOTNET;
    public boolean Bootstrap;
    public boolean Django;
    public boolean Electron;
    public boolean Ember;
    public boolean Express;
    public boolean Firebase;
    public boolean Flask;
    public boolean jQuery;
    public boolean Keras;
    public boolean Koa;
    public boolean Node;
    public boolean RubyOnRails;
    public boolean Ratchet;
    public boolean React;
    public boolean ReactNative;
    public boolean ReactiveUI;
    public boolean Scikit;
    public boolean Spring;
    public boolean Symfony;
    public boolean TensorFlow;
    public boolean Thymeleaf;
    public boolean Vue;
}
