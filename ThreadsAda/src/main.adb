with Ada.Text_IO;

procedure Main is
   Stop : Boolean := False;
   pragma Atomic(Stop);

   task type Alpha_Th;
   task type Beta_Th;

   task body Alpha_Th is
      Sigma : Long_Long_Integer := 0;
   begin
      loop
         Sigma := Sigma + 2;
         exit when Stop;
      end loop;
      delay 1.0;

      Ada.Text_IO.Put_Line(Sigma'Img);
   end Alpha_Th;

   task body Beta_Th is
   begin
      delay 30.0;
      Stop := True;
   end Beta_Th;

   Epsilon : Integer := 4; -- Epsilon is threads count

   type Threads is array(1..Epsilon) of access Alpha_Th; --access Alpha_Th

   All_Threads : Threads;

begin
   for I in 1..Epsilon loop
      All_Threads(I) := new Alpha_Th;
   end loop;

end Main;
