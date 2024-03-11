with Ada.Text_IO;

procedure Main is
   stop : Boolean := false;
   pragma Atomic(stop);

   task type alpha_th;
   task type beta_th;

   task body alpha_th is
      sigma : Long_Long_Integer := 0;
   begin
      loop
         sigma := sigma + 2;
         exit when stop;
      end loop;
      delay 1.0;

      Ada.Text_IO.Put_Line(sigma'Img);
   end alpha_th;

   task body beta_th is
   begin
      delay 30.0;
      stop := true;
   end beta_th;

   alpha : beta_th;
   beta : alpha_th;
   gamma : alpha_th;
   deltaa : alpha_th;
   eta : alpha_th;
   teta : alpha_th;

begin
   null;
end Main;
