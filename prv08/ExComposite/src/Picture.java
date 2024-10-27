import java.util.ArrayList;

public class Picture extends Graphic{
ArrayList<Graphic> graphics = new ArrayList<>();

public Picture(String graphic) {
	this.graphic = graphic;
}

@Override
public void Draw() {
	for(Graphic g : graphics) {
		g.Draw();
	}
}

@Override
public void Add(Graphic graphic) {
	this.graphics.add(graphic);
}

@Override
public void Remove(Graphic graphic) {
	for (Graphic g : graphics) {
		if (g == graphic) {
			this.graphics.remove(g);
			return;
		}
	};
}

@Override
public Graphic GetChild(int child) {
	return this.graphics.get(child);
}



}
