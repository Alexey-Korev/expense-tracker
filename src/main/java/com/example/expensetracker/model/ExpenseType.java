package com.example.expensetracker.model;

public enum ExpenseType {
    GROCERIES("Продукты питания"),
    DINING_OUT("Обеды/ужины вне дома"),
    RENT_OR_MORTGAGE("Аренда/ипотека"),
    UTILITIES("Коммунальные услуги"),
    HOME_MAINTENANCE("Ремонт и обслуживание"),
    PERSONAL_TRANSPORT("Личный транспорт"),
    PUBLIC_TRANSPORT("Общественный транспорт"),
    TAXI("Такси"),
    MEDICAL_SERVICES("Медицинские услуги"),
    MEDICATION("Лекарства"),
    INSURANCE("Страховка"),
    ENTERTAINMENT("Кино/театры"),
    TRAVEL("Путешествия"),
    SPORTS_FITNESS("Спорт и фитнес"),
    EDUCATION("Курсы и тренинги"),
    SCHOOL_UNIVERSITY("Школа/университет"),
    CLOTHING("Одежда и обувь"),
    COSMETICS("Косметика и средства ухода"),
    MOBILE_PHONE("Мобильная связь"),
    INTERNET("Интернет"),
    PET_FOOD("Еда для животных"),
    VET_SERVICES("Ветеринарные услуги"),
    GIFTS("Подарки"),
    DONATIONS("Пожертвования"),
    LOANS("Кредиты и займы"),
    INVESTMENTS("Инвестиции");

    private final String title;

    ExpenseType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
