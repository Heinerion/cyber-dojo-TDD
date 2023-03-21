package de.hsp.tdd.align_columns;

public class AlignColumnsDemo {
  public static void main(String[] args) {
    String example = new AlignColumns(""
        + "Given$a$text$file$of$many$lines,$where$fields$within$a$line$\n"
        + "are$delineated$by$a$single$'dollar'$character,$write$a$program\n"
        + "that$aligns$each$column$of$fields$by$ensuring$that$words$in$each$\n"
        + "column$are$separated$by$at$least$one$space.")
        .align();

    System.out.println(example);
  }
}
