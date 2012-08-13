package com.gshakhn.idea.idea.fitnesse.lang.lexer

class TableLexerSuite extends LexerSuite {
  test("Simple table") {
    expect(
      List(
        (FitnesseTokenType.TABLE_START, ""),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "A"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "B"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "C"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "D"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.TABLE_END, ""),
        (FitnesseTokenType.LINE_TERMINATOR, "\n")
      )) {
      lex("|A|B|\n|C|D|\n\n")
    }
  }

  test("Simple table with CRLF") {
    expect(
      List(
        (FitnesseTokenType.TABLE_START, ""),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "A"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "B"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\r\n"),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "C"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "D"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\r\n"),
        (FitnesseTokenType.TABLE_END, ""),
        (FitnesseTokenType.LINE_TERMINATOR, "\r\n")
      )) {
      lex("|A|B|\r\n|C|D|\r\n\r\n")
    }
  }

  test("Decision table") {
    expect(
      List(
        (FitnesseTokenType.TABLE_START, ""),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Class"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Arg1"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Arg2"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "numerator"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "denominator"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "quotient?"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "10"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "5"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "2"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "20"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "4"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "5"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.TABLE_END, ""),
        (FitnesseTokenType.LINE_TERMINATOR, "\n")
      )) {
      lex("|Class|Arg1|Arg2|\n|numerator|denominator|quotient?|\n|10|5|2|\n|20|4|5|\n\n")
    }
  }

  test("Query table") {
    expect(
      List(
        (FitnesseTokenType.TABLE_START, ""),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Query:some stuff"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "with param1"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Col1"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Col2"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Result 1 Col1"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Result 1 Col2"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.TABLE_END, ""),
        (FitnesseTokenType.LINE_TERMINATOR, "\n")
      )) {
      lex("|Query:some stuff|with param1|\n|Col1|Col2|\n|Result 1 Col1|Result 1 Col2|\n\n")
    }
  }

  test("Ordered Query table") {
    expect(
      List(
        (FitnesseTokenType.TABLE_START, ""),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Ordered query:some stuff"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "with param1"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Col1"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Col2"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Result 1 Col1"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Result 1 Col2"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.TABLE_END, ""),
        (FitnesseTokenType.LINE_TERMINATOR, "\n")
      )) {
      lex("|Ordered query:some stuff|with param1|\n|Col1|Col2|\n|Result 1 Col1|Result 1 Col2|\n\n")
    }
  }

  test("Subset Query table") {
    expect(
      List(
        (FitnesseTokenType.TABLE_START, ""),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Subset query:some stuff"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "with param1"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Col1"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Col2"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Result 1 Col1"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Result 1 Col2"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.TABLE_END, ""),
        (FitnesseTokenType.LINE_TERMINATOR, "\n")
      )) {
      lex("|Subset query:some stuff|with param1|\n|Col1|Col2|\n|Result 1 Col1|Result 1 Col2|\n\n")
    }
  }

  test("Table table") {
    expect(
      List(
        (FitnesseTokenType.TABLE_START, ""),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Table:Some Table"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "row1 col1"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "row1 col2"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "row2 col1"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "row2 col2"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.TABLE_END, ""),
        (FitnesseTokenType.LINE_TERMINATOR, "\n")
      )) {
      lex("|Table:Some Table|\n|row1 col1|row1 col2|\n|row2 col1|row2 col2|\n\n")
    }
  }

  test("Import Table") {
    expect(
      List(
        (FitnesseTokenType.TABLE_START, ""),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Import"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "import1"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "import2"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.TABLE_END, ""),
        (FitnesseTokenType.LINE_TERMINATOR, "\n")
      )) {
      lex("|Import|\n|import1|\n|import2|\n\n")
    }
  }

  test("Table with empty cell") {
    expect(
      List(
        (FitnesseTokenType.TABLE_START, ""),
        (FitnesseTokenType.ROW_START, ""),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_TEXT, "Some table"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.CELL_DELIM, "|"),
        (FitnesseTokenType.ROW_END, "\n"),
        (FitnesseTokenType.TABLE_END, ""),
        (FitnesseTokenType.LINE_TERMINATOR, "\n")
      )) {
      lex("|Some table||\n\n")
    }
  }
}