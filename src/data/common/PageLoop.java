package data.common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PageLoop {
    final AppView view;

    int getChildrenSize() {
        return view.children.size();
    }

    int getOptionalSize() {
        int optionalSize = 0;
        if (view.hasNextPage) optionalSize++;
        if (view.hasPreviousPage) optionalSize++;
        optionalSize += view.availableComparators.size();
        return optionalSize;
    }

    final int getFullSize() {
        return getChildrenSize() + getOptionalSize() + 1;
    }

    public PageLoop(AppView view) {
        this.view = view;
    }

    public void run() {
        int value;
        while (true) {
            view.action();
            System.out.println(view.title);
            System.out.println("Выберите вариант(от 1 до " + getFullSize() + ")");
            displayChildren();

            Scanner in = new Scanner(System.in);
            try {
                value = in.nextInt();
                if (value < 0 || value > getFullSize()) {
                    throw new RuntimeException();
//                System.out.println("Неверное значение страницы");
                } else if (value == getFullSize()) {//назад
                    break;
                } else if (value <=getChildrenSize()) {
                    AppView selectedView = view.children.get(value - 1);
                    new PageLoop(selectedView).run();
                } else {
                    if (value == getChildrenSize() + 1+(view.hasPreviousPage?1:0) && view.hasNextPage) {
                        view.nowPage++;
                        new PageLoop(view).run();
                    }
                    if (value == getChildrenSize() +1 && view.hasPreviousPage) {
                        view.nowPage--;
                        new PageLoop(view).run();
                    } else {
                        view.nowPage = 0;
                        int comparatorIndex = value - getChildrenSize() - 1 - (view.hasNextPage ? 1 : 0);
                        view.selectedComparator = view.availableComparators.get(comparatorIndex);
                        new PageLoop(view).run();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Введите цифру");
            } catch (RuntimeException e) {
                System.out.println("Неверный ввод.Введите цифру от 1 до " + getFullSize());
            }
//            view.children
        }
    }

    void displayChildren() {
        int currentIndex = 1;

        for (int i = 0; i < getChildrenSize(); i++) {
            AppView _view = view.children.get(i);
            System.out.println(currentIndex + " - " + _view.title);
            currentIndex++;
        }
        if (view.hasPreviousPage) {
            System.out.println(currentIndex + " - " + "Предыдующая страница");
            currentIndex++;
        }
        if (view.hasNextPage) {
            System.out.println(currentIndex + " - " + "Следующая страница");
            currentIndex++;
        }
        for (int i = 0; i < view.availableComparators.size(); i++) {
            System.out.println(currentIndex + " - " + view.availableComparators.get(i).name);
            currentIndex++;
        }
        System.out.println((getChildrenSize() + getOptionalSize() + 1) + " - Назад");
        System.out.println();
    }

}
