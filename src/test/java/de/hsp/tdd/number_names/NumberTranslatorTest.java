package de.hsp.tdd.number_names;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NumberTranslatorTest {
  @Test
  void translates_0() {
    assertEquals("zero", new NumberTranslator().translate(0));
  }

  @Test
  void translates_1() {
    assertEquals("one", new NumberTranslator().translate(1));
  }

  @Test
  void translates_2() {
    assertEquals("two", new NumberTranslator().translate(2));
  }

  @Test
  void translates_3() {
    assertEquals("three", new NumberTranslator().translate(3));
  }

  @Test
  void translates_4() {
    assertEquals("four", new NumberTranslator().translate(4));
  }

  @Test
  void translates_5() {
    assertEquals("five", new NumberTranslator().translate(5));
  }

  @Test
  void translates_6() {
    assertEquals("six", new NumberTranslator().translate(6));
  }

  @Test
  void translates_7() {
    assertEquals("seven", new NumberTranslator().translate(7));
  }

  @Test
  void translates_8() {
    assertEquals("eight", new NumberTranslator().translate(8));
  }

  @Test
  void translates_9() {
    assertEquals("nine", new NumberTranslator().translate(9));
  }

  @Test
  void translates_10() {
    assertEquals("ten", new NumberTranslator().translate(10));
  }

  @Test
  void translates_11() {
    assertEquals("eleven", new NumberTranslator().translate(11));
  }

  @Test
  void translates_12() {
    assertEquals("twelve", new NumberTranslator().translate(12));
  }

  @Test
  void translates_13() {
    assertEquals("thirteen", new NumberTranslator().translate(13));
  }

  @Test
  void translates_14() {
    assertEquals("fourteen", new NumberTranslator().translate(14));
  }

  @Test
  void translates_15() {
    assertEquals("fifteen", new NumberTranslator().translate(15));
  }

  @Test
  void translates_16() {
    assertEquals("sixteen", new NumberTranslator().translate(16));
  }

  @Test
  void translates_17() {
    assertEquals("seventeen", new NumberTranslator().translate(17));
  }

  @Test
  void translates_18() {
    assertEquals("eighteen", new NumberTranslator().translate(18));
  }

  @Test
  void translates_19() {
    assertEquals("nineteen", new NumberTranslator().translate(19));
  }

  @Test
  void translates_20() {
    assertEquals("twenty", new NumberTranslator().translate(20));
  }

  @Test
  void translates_30() {
    assertEquals("thirty", new NumberTranslator().translate(30));
  }

  @Test
  void translates_40() {
    assertEquals("forty", new NumberTranslator().translate(40));
  }

  @Test
  void translates_50() {
    assertEquals("fifty", new NumberTranslator().translate(50));
  }

  @Test
  void translates_60() {
    assertEquals("sixty", new NumberTranslator().translate(60));
  }

  @Test
  void translates_70() {
    assertEquals("seventy", new NumberTranslator().translate(70));
  }

  @Test
  void translates_80() {
    assertEquals("eighty", new NumberTranslator().translate(80));
  }

  @Test
  void translates_90() {
    assertEquals("ninety", new NumberTranslator().translate(90));
  }

  @Test
  void translates_77() {
    assertEquals("seventy seven", new NumberTranslator().translate(77));
  }

  @Test
  void translates_38() {
    assertEquals("thirty eight", new NumberTranslator().translate(38));
  }

  @Test
  void translates_100() {
    assertEquals("one hundred", new NumberTranslator().translate(100));
  }

  @Test
  void translates_400() {
    assertEquals("four hundred", new NumberTranslator().translate(400));
  }

  @Test
  void translates_105() {
    assertEquals("one hundred and five", new NumberTranslator().translate(105));
  }

  @Test
  void translates_317() {
    assertEquals("three hundred and seventeen", new NumberTranslator().translate(317));
  }

  //  o) 99 --> ninety nine
  @Test
  void translates_99() {
    assertEquals("ninety nine", new NumberTranslator().translate(99));
  }

  //  o) 300 --> three hundred
  @Test
  void translates_300() {
    assertEquals("three hundred", new NumberTranslator().translate(300));
  }

  //  o) 310 --> three hundred and ten
  @Test
  void translates_310() {
    assertEquals("three hundred and ten", new NumberTranslator().translate(310));
  }

  //  o) 1501 --> one thousand, five hundred and one
  @Test
  void translates_1501() {
    assertEquals("one thousand, five hundred and one", new NumberTranslator().translate(1501));
  }

  //  o) 12609 --> twelve thousand, six hundred and nine
  @Test
  void translates_12609() {
    assertEquals("twelve thousand, six hundred and nine", new NumberTranslator().translate(12_609));
  }

  //  o) 512607 --> five hundred and twelve thousand, six hundred and seven
  @Test
  void translates_512607() {
    assertEquals("five hundred and twelve thousand, six hundred and seven", new NumberTranslator().translate(512_607));
  }

  //   o) 43112603 --> forty three million, one hundred and twelve thousand, six hundred and three
  @Test
  void translates_43112603() {
    assertEquals("forty three million, one hundred and twelve thousand, six hundred and three", new NumberTranslator().translate(43_112_603));
  }

  @Test
  void translates_8348359185() {
    assertEquals("eight billion, three hundred and forty eight million, three hundred and fifty nine thousand, one hundred and eighty five",
        new NumberTranslator().translate(8_348_359_185L));
  }

  @Test
  void translates_negative() {
    assertEquals("minus eight billion, three hundred and forty eight million, three hundred and fifty nine thousand, one hundred and eighty five",
        new NumberTranslator().translate(-8_348_359_185L));
  }
}
