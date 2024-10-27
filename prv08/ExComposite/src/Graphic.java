
public class Graphic {
	String graphic;
public void Draw() {
	System.out.println(this.graphic);
}

public void Add(Graphic graphic) {
	
}

public void Remove(Graphic graphic) {
	
}

public Graphic GetChild(int child){
	return null;
}

public static void main (String[] args) {
	Graphic Picture = new Picture("Foto");
	Graphic Line = new Line("Linha");
	Graphic Rectangle = new Rectangle("Retângulo");
	Graphic Text = new Text("Texto");
	

	Picture.Add(Line);
	Picture.Add(Rectangle);
	Picture.Add(Text);
	Picture.Draw(); // imprimir

}

}
