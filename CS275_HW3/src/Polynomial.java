// Matthew Massom
// CS275
// Assignment 3
// November 19, 2019

import java.util.LinkedList;
import java.util.ListIterator;
import java.lang.Math;

public class Polynomial {
    private static class Term{
        private double coefficient;
        private int exponent;

        public Term(int exp, double coef){
            coefficient = coef;
            exponent = exp;
        }
    }

    private LinkedList<Term> termList;
    public LinkedList<Term> first;

    public Polynomial(){
        termList = new LinkedList<Term>();
        termList.add(new Term(0,0));
    }

    public Polynomial(double a0){
        termList = new LinkedList<Term>();
        termList.add(new Term(0, a0));
    }

    public Polynomial(Polynomial p){
        termList = new LinkedList<Term>();
        for(int index = 0; index < p.termList.size(); index++){
            this.termList.add(p.termList.get(index));
        }
    }

    public void add_to_coef(double amount, int exponent){
        if(exponent > termList.get(0).exponent){
            termList.add(new Term(0, 0));
            for(int index = termList.size() - 1; index > 0; index--){
                termList.set(index, termList.get(index - 1));
            }
            termList.set(0, new Term(exponent, amount));
        }
        else{
            boolean exists = false;
            int index = 0;
            for(; index < termList.size(); index++) {
                if (termList.get(index).exponent == exponent) {
                    exists = true;
                    break;
                }
            }
            if(exists == true){
                termList.set(index, new Term(exponent, termList.get(index).coefficient + amount));
            }
            else{
                index = 0;
                for(; index < termList.size(); index++){
                    if(termList.get(index).exponent < exponent){
                        break;
                    }
                }
                termList.add(new Term(0, 0));
                for(int i = termList.size() - 1; i > index; i--){
                    termList.set(i, termList.get(i - 1));
                }
                termList.set(index, new Term(exponent, amount));
            }
        }
    }

    public void assign_coef(double coefficient, int exponent){
        if(exponent > termList.get(0).exponent){
            termList.add(new Term(0, 0));
            for(int index = termList.size() - 1; index > 0; index--){
                termList.set(index, termList.get(index - 1));
            }
            termList.set(0, new Term(exponent, coefficient));
        }
        else{
            boolean exists = false;
            int index = 0;
            for(; index < termList.size(); index++) {
                if (termList.get(index).exponent == exponent) {
                    exists = true;
                    break;
                }
            }
            if(exists == true){
                termList.set(index, new Term(exponent, coefficient));
            }
            else{
                index = 0;
                for(; index < termList.size(); index++){
                    if(termList.get(index).exponent < exponent){
                        break;
                    }
                }
                termList.add(new Term(0, 0));
                for(int i = termList.size() - 1; i > index; i--){
                    termList.set(i, termList.get(i - 1));
                }
                termList.set(index, new Term(exponent, coefficient));
            }
        }
    }

    public double coefficient(int exponent){
        for(int index = 0; index < termList.size(); index++){
            if(termList.get(index).exponent == exponent){
                return termList.get(index).coefficient;
            }
        }
        return 0;
    }

    public double eval(double x){
        double ans = 0;
        for(int index = 0; index < termList.size(); index++){
            ans = ans + termList.get(index).coefficient * Math.pow(x, termList.get(index).exponent);
        }
        return ans;
    }

    public String toString(){
        String str = "";
        if(termList.get(0).exponent == 0){
            return str + termList.get(0).coefficient;
        }
        int index = 0;
        for(; index < termList.size() - 2; index++){
            if(termList.get(index).coefficient != 0){
                str = str + termList.get(index).coefficient + "x^" + termList.get(index).exponent;
                if(termList.get(index+1).coefficient != 0){
                    str = str + " + ";
                }
            }
        }
        if(termList.get(index).coefficient != 0){
            if(termList.get(index).exponent == 1) {
                str = str + termList.get(index).coefficient + "x";
            }
            else{
                str = str + termList.get(index).coefficient + "x^" + termList.get(index).exponent;
            }
        }
        index++;
        if(termList.get(index).coefficient != 0){
            str = str + " + " + termList.get(index).coefficient;
        }
        if(str == ""){
            str = str + 0;
        }
        return str;
    }

    public Polynomial add(Polynomial p){
        Polynomial pNew;
        if(this.termList.get(0).exponent >= p.termList.get(0).exponent){
            pNew = new Polynomial(this);
            for (int index = 0; index < p.termList.size(); index++){
                pNew.add_to_coef(p.termList.get(index).coefficient, p.termList.get(index).exponent);
            }
        }
        else{
            pNew = new Polynomial(p);
            for(int index = 0; index < this.termList.size(); index++){
                pNew.add_to_coef(this.termList.get(index).coefficient, this.termList.get(index).exponent);
            }
        }
        return pNew;
    }

    public Polynomial multiply(Polynomial p){
        Polynomial pNew = new Polynomial();
        for(int index1 = 0; index1 < this.termList.size(); index1++){
            for(int index2 =0; index2 < p.termList.size(); index2++){
                pNew.add_to_coef(this.termList.get(index1).coefficient * p.termList.get(index2).coefficient, this.termList.get(index1).exponent + p.termList.get(index2).exponent);
            }
        }
        return pNew;
    }

}
