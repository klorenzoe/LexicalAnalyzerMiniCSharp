/* The following code was generated by JFlex 1.4.3 on 10/11/18 6:26 PM */


package minicsharpanalyzer;
//import static minicsharpanalyzer.Token.*;
import java_cup.runtime.*;
//import java-cup-11a.runtime.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 10/11/18 6:26 PM from the specification file
 * <tt>src/minicsharpanalyzer/Rules.flex</tt>
 */
class Rules implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\11\2\0\1\6\22\0\1\3\1\55\1\7\2\0"+
    "\1\54\1\57\1\0\1\62\1\63\1\5\1\53\1\54\1\53\1\12"+
    "\1\4\1\70\11\2\1\0\1\54\1\55\1\56\1\55\2\0\1\42"+
    "\1\52\2\67\1\66\1\67\1\51\1\1\1\46\2\1\1\47\1\50"+
    "\1\41\1\1\1\44\1\1\1\45\1\51\4\1\1\71\2\1\1\60"+
    "\1\10\1\61\1\0\1\1\1\0\1\31\1\22\1\30\1\16\1\24"+
    "\1\32\1\27\1\33\1\15\1\1\1\40\1\23\1\35\1\17\1\14"+
    "\1\36\1\1\1\26\1\25\1\20\1\21\1\13\1\37\1\34\1\43"+
    "\1\1\1\64\1\3\1\65\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\2\5\1\1\21\2"+
    "\1\5\1\1\3\5\1\3\1\6\1\4\2\0\1\7"+
    "\1\0\2\2\1\10\24\2\5\0\1\2\1\10\15\2"+
    "\1\10\4\2\1\3\1\6\1\0\3\11\1\12\2\2"+
    "\1\13\11\2\1\11\1\12\1\0\12\2\1\0\5\2"+
    "\1\0\7\2";

  private static int [] zzUnpackAction() {
    int [] result = new int[131];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\72\0\164\0\256\0\350\0\u0122\0\72\0\u015c"+
    "\0\u0196\0\u01d0\0\u020a\0\u0244\0\u027e\0\u02b8\0\u02f2\0\u032c"+
    "\0\u0366\0\u03a0\0\u03da\0\u0414\0\u044e\0\u0488\0\u04c2\0\u04fc"+
    "\0\u0536\0\u0570\0\u05aa\0\u05e4\0\u061e\0\u0658\0\u0692\0\u06cc"+
    "\0\u0706\0\u0740\0\u015c\0\72\0\u077a\0\u07b4\0\u07ee\0\164"+
    "\0\u0828\0\u0862\0\u089c\0\u08d6\0\u0910\0\u094a\0\u0984\0\u09be"+
    "\0\u09f8\0\u0a32\0\u0a6c\0\u0aa6\0\u0ae0\0\u0b1a\0\u0b54\0\u0b8e"+
    "\0\u0bc8\0\u0c02\0\u0c3c\0\u0c76\0\u0cb0\0\u0cea\0\u0d24\0\u0d5e"+
    "\0\u0d98\0\u0dd2\0\u0e0c\0\u0e46\0\u0e80\0\u0eba\0\u0ef4\0\u0f2e"+
    "\0\u0f68\0\u0fa2\0\u0fdc\0\u1016\0\u1050\0\u108a\0\u10c4\0\u10fe"+
    "\0\u1138\0\u1172\0\u11ac\0\u11e6\0\u1220\0\u0cb0\0\u125a\0\u125a"+
    "\0\u0d24\0\u1294\0\u12ce\0\u0d5e\0\u1308\0\u1342\0\164\0\u137c"+
    "\0\u13b6\0\u13f0\0\u142a\0\u1464\0\u149e\0\u14d8\0\u1512\0\u154c"+
    "\0\u1586\0\72\0\u15c0\0\u15fa\0\u1634\0\u166e\0\u16a8\0\u16e2"+
    "\0\u171c\0\u1756\0\u1790\0\u17ca\0\u1804\0\u183e\0\u1878\0\u18b2"+
    "\0\u18ec\0\u1926\0\u1960\0\u199a\0\u19d4\0\u1a0e\0\u1a48\0\u1a82"+
    "\0\u1abc\0\u1af6\0\u1b30";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[131];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\5\1\10"+
    "\1\2\1\5\1\7\1\11\1\3\1\12\1\13\1\14"+
    "\1\15\1\3\1\16\1\3\1\17\1\20\1\21\1\3"+
    "\1\22\1\3\1\23\4\3\1\24\1\3\1\25\2\3"+
    "\1\26\1\27\2\3\1\30\1\31\1\3\2\7\2\32"+
    "\1\33\1\34\1\7\1\35\1\7\1\36\1\7\2\3"+
    "\1\37\1\3\73\0\2\3\10\0\40\3\13\0\4\3"+
    "\2\0\1\4\7\0\1\40\55\0\1\4\4\0\1\5"+
    "\2\0\1\5\2\0\1\5\64\0\1\41\1\42\64\0"+
    "\7\43\1\44\1\45\1\0\60\43\1\0\2\3\10\0"+
    "\1\3\1\46\36\3\13\0\4\3\1\0\2\3\10\0"+
    "\4\3\1\47\12\3\1\50\2\3\1\51\15\3\13\0"+
    "\4\3\1\0\2\3\10\0\1\3\1\52\36\3\13\0"+
    "\4\3\1\0\2\3\10\0\6\3\1\53\31\3\13\0"+
    "\4\3\1\0\2\3\10\0\13\3\1\54\4\3\1\55"+
    "\17\3\13\0\4\3\1\0\2\3\10\0\1\3\1\56"+
    "\11\3\1\57\24\3\13\0\4\3\1\0\2\3\10\0"+
    "\10\3\1\60\10\3\1\61\16\3\13\0\4\3\1\0"+
    "\2\3\10\0\5\3\1\62\32\3\13\0\4\3\1\0"+
    "\2\3\10\0\11\3\1\63\26\3\13\0\4\3\1\0"+
    "\2\3\10\0\10\3\1\64\27\3\13\0\4\3\1\0"+
    "\2\3\10\0\1\3\1\65\14\3\1\66\21\3\13\0"+
    "\4\3\1\0\2\3\10\0\20\3\1\67\17\3\13\0"+
    "\4\3\1\0\2\3\10\0\11\3\1\70\26\3\13\0"+
    "\4\3\1\0\2\3\10\0\13\3\1\71\24\3\13\0"+
    "\4\3\1\0\2\3\10\0\11\3\1\72\26\3\13\0"+
    "\4\3\1\0\2\3\10\0\16\3\1\73\21\3\13\0"+
    "\4\3\1\0\2\3\10\0\11\3\1\74\26\3\13\0"+
    "\4\3\56\0\1\7\72\0\1\7\73\0\1\7\73\0"+
    "\1\7\73\0\1\7\6\0\1\4\7\0\1\40\21\0"+
    "\1\75\33\0\1\4\1\75\2\0\1\40\21\0\1\76"+
    "\41\0\1\76\1\0\1\40\1\0\6\41\1\0\2\41"+
    "\1\0\60\41\4\77\1\100\1\101\64\77\11\0\2\43"+
    "\60\0\2\3\10\0\2\3\1\102\35\3\13\0\4\3"+
    "\1\0\2\3\10\0\5\3\1\103\32\3\13\0\4\3"+
    "\1\0\2\3\10\0\23\3\1\104\14\3\13\0\4\3"+
    "\1\0\2\3\10\0\6\3\1\105\31\3\13\0\4\3"+
    "\1\0\2\3\10\0\10\3\1\106\27\3\13\0\4\3"+
    "\1\0\2\3\10\0\6\3\1\107\31\3\13\0\4\3"+
    "\1\0\2\3\10\0\2\3\1\110\35\3\13\0\4\3"+
    "\1\0\2\3\10\0\1\3\1\106\36\3\13\0\4\3"+
    "\1\0\2\3\10\0\11\3\1\111\26\3\13\0\4\3"+
    "\1\0\2\3\10\0\12\3\1\112\25\3\13\0\4\3"+
    "\1\0\2\3\10\0\5\3\1\113\32\3\13\0\4\3"+
    "\1\0\2\3\10\0\13\3\1\114\24\3\13\0\4\3"+
    "\1\0\2\3\10\0\5\3\1\115\32\3\13\0\4\3"+
    "\1\0\2\3\10\0\16\3\1\116\21\3\13\0\4\3"+
    "\1\0\2\3\10\0\13\3\1\50\24\3\13\0\4\3"+
    "\1\0\2\3\10\0\10\3\1\117\27\3\13\0\4\3"+
    "\1\0\2\3\10\0\2\3\1\120\35\3\13\0\4\3"+
    "\1\0\2\3\10\0\24\3\1\121\13\3\13\0\4\3"+
    "\1\0\2\3\10\0\2\3\1\122\35\3\13\0\4\3"+
    "\1\0\2\3\10\0\16\3\1\123\21\3\13\0\4\3"+
    "\1\0\2\3\10\0\10\3\1\124\27\3\13\0\4\3"+
    "\1\0\2\3\10\0\5\3\1\125\32\3\13\0\4\3"+
    "\2\0\1\126\13\0\1\126\3\0\1\126\1\0\1\126"+
    "\3\0\3\126\7\0\1\126\7\0\1\126\13\0\3\126"+
    "\3\0\1\127\50\0\1\130\14\0\1\127\1\0\4\131"+
    "\1\77\1\132\70\131\1\100\1\133\64\131\4\77\1\134"+
    "\1\101\64\77\1\0\2\3\10\0\3\3\1\50\34\3"+
    "\13\0\4\3\1\0\2\3\10\0\11\3\1\135\26\3"+
    "\13\0\4\3\1\0\2\3\10\0\10\3\1\136\27\3"+
    "\13\0\4\3\1\0\2\3\10\0\7\3\1\120\30\3"+
    "\13\0\4\3\1\0\2\3\10\0\10\3\1\50\27\3"+
    "\13\0\4\3\1\0\2\3\10\0\11\3\1\137\26\3"+
    "\13\0\4\3\1\0\2\3\10\0\12\3\1\50\25\3"+
    "\13\0\4\3\1\0\2\3\10\0\16\3\1\140\21\3"+
    "\13\0\4\3\1\0\2\3\10\0\11\3\1\50\26\3"+
    "\13\0\4\3\1\0\2\3\10\0\11\3\1\141\26\3"+
    "\13\0\4\3\1\0\2\3\10\0\2\3\1\142\35\3"+
    "\13\0\4\3\1\0\2\3\10\0\6\3\1\143\31\3"+
    "\13\0\4\3\1\0\2\3\10\0\12\3\1\110\25\3"+
    "\13\0\4\3\1\0\2\3\10\0\12\3\1\107\25\3"+
    "\13\0\4\3\1\0\2\3\10\0\10\3\1\112\27\3"+
    "\13\0\4\3\1\0\2\3\10\0\27\3\1\144\10\3"+
    "\13\0\4\3\1\0\2\3\10\0\4\3\1\145\33\3"+
    "\13\0\4\3\1\0\2\3\10\0\3\3\1\146\34\3"+
    "\13\0\4\3\1\0\2\3\10\0\10\3\1\147\27\3"+
    "\13\0\4\3\1\0\2\3\10\0\37\3\1\150\13\0"+
    "\4\3\2\0\1\127\65\0\1\127\1\0\4\151\1\152"+
    "\1\132\70\151\1\153\1\133\64\151\1\0\2\3\10\0"+
    "\13\3\1\154\24\3\13\0\4\3\1\0\2\3\10\0"+
    "\11\3\1\155\26\3\13\0\4\3\1\0\2\3\10\0"+
    "\25\3\1\50\12\3\13\0\4\3\1\0\2\3\10\0"+
    "\4\3\1\156\33\3\13\0\4\3\1\0\2\3\10\0"+
    "\4\3\1\157\33\3\13\0\4\3\1\0\2\3\10\0"+
    "\13\3\1\160\24\3\13\0\4\3\1\0\2\3\10\0"+
    "\13\3\1\161\24\3\13\0\4\3\1\0\2\3\10\0"+
    "\5\3\1\50\32\3\13\0\4\3\1\0\2\3\10\0"+
    "\33\3\1\162\1\163\3\3\13\0\4\3\1\0\2\3"+
    "\10\0\1\3\1\164\36\3\13\0\4\3\1\0\2\3"+
    "\10\0\30\3\1\165\7\3\13\0\4\3\4\151\1\166"+
    "\1\132\64\151\4\166\2\153\64\166\1\0\2\3\10\0"+
    "\17\3\1\167\20\3\13\0\4\3\1\0\2\3\10\0"+
    "\22\3\1\170\15\3\13\0\4\3\1\0\2\3\10\0"+
    "\3\3\1\110\34\3\13\0\4\3\1\0\2\3\10\0"+
    "\14\3\1\50\23\3\13\0\4\3\1\0\2\3\10\0"+
    "\4\3\1\50\33\3\13\0\4\3\1\0\2\3\10\0"+
    "\13\3\1\171\24\3\13\0\4\3\1\0\2\3\10\0"+
    "\4\3\1\172\33\3\13\0\4\3\1\0\2\3\10\0"+
    "\2\3\1\173\35\3\13\0\4\3\1\0\2\3\10\0"+
    "\15\3\1\50\22\3\13\0\4\3\1\0\2\3\10\0"+
    "\5\3\1\112\32\3\13\0\4\3\5\166\1\174\64\166"+
    "\1\0\2\3\10\0\16\3\1\175\21\3\13\0\4\3"+
    "\1\0\2\3\10\0\11\3\1\176\26\3\13\0\4\3"+
    "\1\0\2\3\10\0\16\3\1\177\21\3\13\0\4\3"+
    "\1\0\2\3\10\0\5\3\1\200\32\3\13\0\4\3"+
    "\1\0\2\3\10\0\4\3\1\112\33\3\13\0\4\3"+
    "\4\166\1\152\1\174\64\166\1\0\2\3\10\0\15\3"+
    "\1\112\22\3\13\0\4\3\1\0\2\3\10\0\4\3"+
    "\1\201\33\3\13\0\4\3\1\0\2\3\10\0\30\3"+
    "\1\50\7\3\13\0\4\3\1\0\2\3\10\0\11\3"+
    "\1\202\26\3\13\0\4\3\1\0\2\3\10\0\5\3"+
    "\1\110\32\3\13\0\4\3\1\0\2\3\10\0\14\3"+
    "\1\203\23\3\13\0\4\3\1\0\2\3\10\0\11\3"+
    "\1\65\26\3\13\0\4\3";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7018];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\4\1\1\11\32\1\2\0\1\11\1\0"+
    "\27\1\5\0\26\1\1\0\21\1\1\11\1\0\12\1"+
    "\1\0\5\1\1\0\7\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[131];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
   StringBuffer string = new StringBuffer();
   private Symbol symbol(int type){
      return new Symbol(type, yyline, yycolumn);
   }
   private Symbol symbol(int type, Object value){
       return new Symbol(type, yyline, yycolumn, value);
   }
    /*public String lexeme = "";
    public int column = 0;
    public int line = 0;*/

   public static String result_lexical_analyzer = "";


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Rules(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Rules(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 170) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 11: 
          { /*lexeme = yytext();
         column = yycolumn;
         line = yyline;
         return BoolConstant;*/
         result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" token bool_constant: \""+yytext()+"\" \n";
         return symbol(sym.BoolConstant);
          }
        case 12: break;
        case 1: 
          { /*lexeme = yytext();
   column = yycolumn;
   line = yyline;
   return Error;*/
   result_lexical_analyzer+= "ERROR line: "+yyline+" column: "+yycolumn+" token: \""+yytext()+"\" \n";
   string.append("Error");
          }
        case 13: break;
        case 7: 
          { /* lexeme = yytext();
            column = yycolumn;
            line = yyline;
            return  StringConstant;*/
            result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" token string_constant: \""+yytext()+"\" \n";
            return symbol(sym.StringConstant);
          }
        case 14: break;
        case 5: 
          { /*lexeme = yytext();
                           column = yycolumn;
                           line = yyline;
                           return OperatorsAndPunctuation;*/
                           result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" token operator_punctuation: \""+yytext()+"\" \n";
                           switch(yytext())
                            {
                                case "+":
                                    return symbol(sym.plus);
                                case "-":
                                    return symbol(sym.minus);
                                case "*":
                                    return symbol(sym.times);
                                case "/":
                                    return symbol(sym.div);
                                case "%":
                                    return symbol(sym.percentage);
                                case "<":
                                    return symbol(sym.smaller);
                                case "<=":
                                    return symbol(sym.smallerEquals);
                                case ">":
                                    return symbol(sym.greater);
                                case ">=":
                                    return symbol(sym.greaterEquals);
                                case "=":
                                    return symbol(sym.assignment);
                                case "==":
                                    return symbol(sym.equals);
                                case "!=":
                                    return symbol(sym.notequals);
                                case "&&":
                                    return symbol(sym.and);
                                case "||":
                                    return symbol(sym.or);
                                case "!":
                                    return symbol(sym.not);
                                case ";":
                                    return symbol(sym.dotcomma);
                                case ",":
                                    return symbol(sym.comma);
                                case ".":
                                    return symbol(sym.point);
                                case "[":
                                
                                    return symbol(sym.claspfirst);
                                case "]":
                                    return symbol(sym.claspsecond);
                                case "(":
                                    return symbol(sym.parentesisfirst);
                                case ")":
                                    return symbol(sym.parentesissecond);
                                case "{":
                                    return symbol(sym.bracketfirst);
                                case "}":
                                    return symbol(sym.bracketsecond);
                                case "[]":
                                    return symbol(sym.clasps);
                                case "()":
                                    return symbol(sym.parentesis);
                                case "{}":
                                    return symbol(sym.brackets);
                                default:
                                    return symbol(sym.notfound);
                            }
          }
        case 15: break;
        case 10: 
          { /* Ignore */
          }
        case 16: break;
        case 9: 
          { /* lexeme = yytext();
                        column = yycolumn;
                        line = yyline;
                        return ErrorComment; */
                        result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" ERROR COMMENT token: \""+yytext()+"\" \n";
                        string.append("ErrorComment");
          }
        case 17: break;
        case 6: 
          { /* lexeme = yytext();
                        column = yycolumn;
                        line = yyline;
                        return DoubleConstant;*/
                        result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" token double_constant: \""+yytext()+"\" \n";
                        return symbol(sym.DoubleConstant);
          }
        case 18: break;
        case 2: 
          { /*lexeme = yytext();
               column = yycolumn;
               line = yyline;
               if(lexeme.length()>31){
                  return ErrorIdentifier;   
               }else{
                  return Identifier;

               }*/
               result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" token identifier: \""+yytext()+"\" \n";
               return symbol(sym.Identifierr);
          }
        case 19: break;
        case 3: 
          { /* lexeme = yytext();
                           column = yycolumn;
                           line = yyline;
                           return IntegerConstant;*/
                           result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" token integer_constant: \""+yytext()+"\" \n";
                           return symbol(sym.IntegerConstant);
          }
        case 20: break;
        case 4: 
          { /*Ignore*/
          }
        case 21: break;
        case 8: 
          { /* lexeme = yytext();
                  column = yycolumn;
                  line = yyline;
                  return ReservedWord;
                  */
                  result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" token reserved_word: \""+yytext()+"\" \n";
                  switch(yytext())
                  {
                      case "void":
                        return symbol(sym.voidd);
                      case "int":
                        return symbol(sym.intt);
                      case "double":
                        return symbol(sym.doublee);
                      case "bool":
                        return symbol(sym.booll);
                      case "string":
                        return symbol(sym.stringg);
                      case "class":
                        return symbol(sym.classs);
                      case "interface":
                        return symbol(sym.interfacee);
                      case "null":
                        return symbol(sym.nulll);
                      case "this":
                        return symbol(sym.thiss);
                      case "extends":
                        return symbol(sym.extendss);
                      case "implements":
                        return symbol(sym.implementss);
                      case "for":
                        return symbol(sym.forr);
                      case "while":
                        return symbol(sym.whilee);
                      case "if":
                        return symbol(sym.iff);
                      case "else":
                        return symbol(sym.elsee);
                      case "return":
                        return symbol(sym.returnn);
                      case "break":
                        return symbol(sym.breakk);
                      case "New":
                        return symbol(sym.neww);
                      case "NewArray":
                        return symbol(sym.newarray);
                      case "Print":
                        return symbol(sym.printt);
                      case "ReadInteger":
                        return symbol(sym.readinteger);
                      case "ReadLine":
                        return symbol(sym.readline);
                      case "Malloc":
                        return symbol(sym.mallocc);
                      case "GetByte":
                        return symbol(sym.getBytee);
                        case "SetByte":
                        return symbol(sym.setBytee);
                      default:
                        return symbol(sym.notfound);
                  }
          }
        case 22: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
