package com.company;

import java.util.ArrayList;



public class Main {
    static ArrayList<FinacialOrganization> listOfOrganizations = new ArrayList<>();

    public static void main(String[] args) throws NoSuchMethodException {
        // write your code here

        listOfOrganizations.add(new Obmenka("Kitgroup", "Kharkiv, peremoga"));
        listOfOrganizations.add(new Bank("UkrGaz", "Kyiv, Peremoha", 1999));
        listOfOrganizations.add(new CreditCafe("SvidkoGroshi", "sdjbjhsbd"));
        listOfOrganizations.add(new CreditUnion("Bistro", "dfjg"));
        listOfOrganizations.add(new Lombard("Nadia", "adsffgdhjkl"));
        listOfOrganizations.add(new Post("UkrPost", "dshdfjsd"));


        findBestExchangetoUsd(20000);
        findBestExchangetoEur(20000);
        findMinStavkaPoCredit(100000);
        findBestPlaceForDepozit(100000, 12);
        findBestPlaceForSendMoney(5000);


    }

    static void findBestExchangetoUsd(double money) { //Ищет лучший курс обмена определенной суммы денег на доллар среди финансовых организаций из ArrayList,
                                                        //которые имплементирую интерфейс Exchange
        double sum = 0;
        int positionOrgInList = 0;

        for (FinacialOrganization org : listOfOrganizations) { //перебор коллекции оргнизаций

            if (org instanceof Exchange) {                     //соответвуетли элемент коллекции выбраому интрефейсу т.е. имеет ли организацияфунци оменаденег
                if (sum < ((Exchange) org).exchangeUahToUsd(money)) {     //т.к в коллекции не одна оргаизация,
                    sum = ((Exchange) org).exchangeUahToUsd(money);       //в переменную  sum будет записываться получаемая сумма обмена ваюты
                    positionOrgInList = listOfOrganizations.indexOf(org); // и индекс в этой организаци в коллекции
                }
                                                                         //после перебора всех элементов полчим самый выгодный курс
            }
        }
        System.out.println("Выгодный курс в организации " + listOfOrganizations.get(positionOrgInList).getClassName() +   //выведем в консоль тип оргаизации и ее название
                " с названием " + listOfOrganizations.get(positionOrgInList).getName());
    }

    static void findBestExchangetoEur(double money) {//Ищет лучший курс обмена определенной суммы денег на евро среди финансовых организаций из ArrayList,
                                                          //которые имплементирую интерфейс Exchange.
        double sum = 0;                                  //идентично предыдущему методу
        int positionOrgInList = 0;

        for (FinacialOrganization org : listOfOrganizations) {

            if (org instanceof Exchange) {
                if (sum < ((Exchange) org).exchangeUahToEur(money)) {
                    sum = ((Exchange) org).exchangeUahToEur(money);
                    positionOrgInList = listOfOrganizations.indexOf(org);
                }

            }
        }
        System.out.println("Выгодный курс в организации " + listOfOrganizations.get(positionOrgInList).getClassName() +
                " с названием " + listOfOrganizations.get(positionOrgInList).getName());
    }

    static void findMinStavkaPoCredit(double money) {  //Ищет лучшую организаию, где менше всего процен по кредту и так же организации имеют ограничения в выдачи
        double sum = 500000;                           //финансов, что учитывает метод howMuchINeedToGiveBack.
        int positionOrgInList = 0;

        for (FinacialOrganization org : listOfOrganizations) {
            if (org instanceof Credits) {
                if (sum > ((Credits) org).howMuchINeedToGiveBack(money) && ((Credits) org).howMuchINeedToGiveBack(money) != 0) {
                    sum = ((Credits) org).howMuchINeedToGiveBack(money);
                    positionOrgInList = listOfOrganizations.indexOf(org);


                }
            }
        }
        if (listOfOrganizations.get(positionOrgInList) instanceof Bank) {             //проверка явлетсли наш объект баком
            Bank bank = (Bank) listOfOrganizations.get(positionOrgInList); //явное привдениетипов, чтобы вытащить из класа нужнойна оргнизции процент за год getPersentPerYear
            System.out.println("Выгодная процентная ставка в организации " +bank.getPersentPerYear()+"% " +
                    listOfOrganizations.get(positionOrgInList).getClassName() + " с названием " + listOfOrganizations.get(positionOrgInList).getName());

        }
        else if(listOfOrganizations.get(positionOrgInList) instanceof Lombard) {         //проверка явлетсли наш объект ломбардом
            Lombard lombard = (Lombard) listOfOrganizations.get(positionOrgInList);
            System.out.println("Выгодная процентная ставка в организации " +lombard.getPersentPerYear()+"% " +
                    listOfOrganizations.get(positionOrgInList).getClassName() + " с названием " + listOfOrganizations.get(positionOrgInList).getName());

        }
        else if(listOfOrganizations.get(positionOrgInList) instanceof CreditUnion) {
            CreditUnion creditUnion = (CreditUnion) listOfOrganizations.get(positionOrgInList);
            System.out.println("Выгодная процентная ставка в организации " +creditUnion.getPersentPerYear()+"% " +
                    listOfOrganizations.get(positionOrgInList).getClassName() + " с названием " + listOfOrganizations.get(positionOrgInList).getName());

        }
        else if(listOfOrganizations.get(positionOrgInList) instanceof CreditCafe) {
            CreditCafe creditCafe= (CreditCafe) listOfOrganizations.get(positionOrgInList);
            System.out.println("Выгодная процентная ставка в организации " +creditCafe.getPersentPerYear()+"% " +
                    listOfOrganizations.get(positionOrgInList).getClassName() + " с названием " + listOfOrganizations.get(positionOrgInList).getName());

        }
    }

        static void findBestPlaceForDepozit ( double money, int month){   //ищим организацию в котоую можно положить деньги под выгоный процент на определеное кол-во мсяцев
            double sum = 0;                                                //в методе putMoney сть оганичеие а кол-во месяцев
            int positionOrgInList = 0;
            for (FinacialOrganization org : listOfOrganizations) {
                if (org instanceof Depozit) {
                    if (sum < ((Depozit) org).putMoney(money, month)) {
                        sum = ((Depozit) org).putMoney(money, month);
                        positionOrgInList = listOfOrganizations.indexOf(org);
                    }

                }
            }
            if (listOfOrganizations.get(positionOrgInList) instanceof Bank) {
                Bank bank = (Bank) listOfOrganizations.get(positionOrgInList);

                System.out.println("Выгодная процентная ставка в организации " + bank.getDepozitProcent() +"% "+ " " +
                        listOfOrganizations.get(positionOrgInList).getClassName() + " с названием " + listOfOrganizations.get(positionOrgInList).getName());

            } else if (listOfOrganizations.get(positionOrgInList) instanceof Piph) {
                Piph piph = (Piph) listOfOrganizations.get(positionOrgInList);

                System.out.println("Выгодная процентная ставка в организации " + piph.getDepozitProcent()+"% " + " " +
                        listOfOrganizations.get(positionOrgInList).getClassName() + " с названием " + listOfOrganizations.get(positionOrgInList).getName());

            }

        }

        static void findBestPlaceForSendMoney(double money){ //ищет лучшую оргаизацию для пересыла денег наложенным платежем
            double sum = 0;
            int positionOrgInList = 0;

            for (FinacialOrganization org : listOfOrganizations) {
                if (org instanceof SendMoney) {
                    if(sum == 0){
                        sum = ((SendMoney) org).sendMoney(money);
                        positionOrgInList = listOfOrganizations.indexOf(org);
                    }
                    else if (sum > ((SendMoney) org).sendMoney(money)) {
                        sum = ((SendMoney) org).sendMoney(money);
                        positionOrgInList = listOfOrganizations.indexOf(org);

                    }

                }

        }
            if (listOfOrganizations.get(positionOrgInList) instanceof Bank) {
                Bank bank = (Bank) listOfOrganizations.get(positionOrgInList);

                System.out.println("Выгодная организация для пересылк денег " +
                        listOfOrganizations.get(positionOrgInList).getClassName() + " с названием " + listOfOrganizations.get(positionOrgInList).getName());
            }
            else if(listOfOrganizations.get(positionOrgInList) instanceof Post){
                Post post = (Post) listOfOrganizations.get(positionOrgInList);
                System.out.println("Выгодная организация для пересылк денег " +
                        listOfOrganizations.get(positionOrgInList).getClassName() + " с названием " + listOfOrganizations.get(positionOrgInList).getName());
            }

    }
    }


