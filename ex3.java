import java.util.*;

class Jam
{
  // Instance Variables
  String contents ;   // type of fruit in the jar
  String date  ;      // date of canning
  int capacity ;      // amount of jam in the jar


  // Constructors
  Jam( String contents, String date, int size )
  {
    this . contents = contents  ;
    this . date = date ;
    capacity = size;
  }

  // Methods
  public boolean empty ()
  {
    return ( capacity== 0 ) ;
  }

  public void print ()
  {
    System.out.println ( contents + "   " +  date + "   " +  capacity + " fl. oz." ) ;
  }

  public void spread ( int fluidOz)
  {
    if ( !empty() )
    {
      if ( fluidOz <= capacity )
      {
        System.out.println("Spreading " + fluidOz + " fluid ounces of "
            + contents );
        capacity = capacity - fluidOz ;
      }
      else
      {
        System.out.println("Spreading " + capacity + " fluid ounces of "
            + contents );
        capacity =  0 ;
      }
     }
     else
       System.out.println("No jam in the Jar!");
  }

}

class Pantry
{
  // Instance Variables
  private Jam  jar1 ;
  private Jam  jar2 ;
  private Jam  jar3 ;
  private Jam  selected ;

  // Constructors
  Pantry( Jam jar1, Jam jar2, Jam jar3 )
  {
    this . jar1 = jar1 ;
    this . jar2 = jar2 ;
    this . jar3 = jar3 ;
    selected = null ;
  }

  Pantry(Jam jar){
    this . jar1 = jar;
    this . jar2 = null;
    this . jar3 = null;
    selected = null;
  }

  Pantry(Jam jar1, Jam jar2){
    this . jar1 = jar1;
    this . jar2 = jar2;
    this . jar3 = null;
    selected = null;
  }

  // Methods
  public void print()
  {
    if(jar1 != null) { System.out.print("1: "); jar1 . print() ;}
    if(jar2 != null) { System.out.print("2: "); jar2 . print() ;}
    if(jar3 != null) { System.out.print("3: "); jar3 . print() ;}
  }

  // assume that the user entered a correct selection, 1, 2, or 3
  public boolean select( int jarNumber )
  {
    boolean there = false;
    if ( jarNumber == 1 ) {
      if(jar1 != null){ selected =  jar1 ;}
      there = (jar1 != null);
    }

    else if ( jarNumber == 2 ) {
      if(jar2 != null){ selected =  jar2 ;}
      there = (jar2 != null);
    }

    else if ( jarNumber == 3 ){
      if(jar3 != null){ selected =  jar3 ;}
      there = (jar3 != null);
    }
    return there;
  }

  // spread the selected jam
  public void spread( int oz )
  {
    selected . spread( oz ) ;
  }

  public void replace(Jam j, int slot) {
    if(slot == 1) { jar1 = j; }
    else if(slot == 2) { jar2 = j; }
    else if(slot == 3) { jar3 = j; }
  }
}

class PantryTester3
{
  public static void main ( String[] args )
  {
    Jam goose = new Jam( "Gooseberry", "7/4/86", 12 );
    Jam apple = new Jam( "Crab Apple", "9/30/99", 8 );
    Jam rhub  = new Jam( "Rhubarb", "10/31/99", 16 );

    Pantry hubbard = new Pantry( goose, apple );
    hubbard.print();

    if ( hubbard.select(3) )
      hubbard.spread(2);
    else
      System.out.println("Selection not available");
    hubbard.print();

    hubbard.replace( rhub, 3 );
    hubbard.print();

    if ( hubbard.select(3) )
      hubbard.spread(2);
    else
      System.out.println("Selection not available");
    hubbard.print();
    
  }
}