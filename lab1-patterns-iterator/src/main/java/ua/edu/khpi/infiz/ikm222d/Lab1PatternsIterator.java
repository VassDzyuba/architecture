package ua.edu.khpi.infiz.ikm222d;

import java.util.Random;

public class Lab1PatternsIterator {

	public static void main(final String[] args) {
		new Lab1PatternsIterator().demo();
	}

	private void demo() {
		final TouristPlacesCollection collection = new TouristPlacesCollection();

		final Iterator ownOpinionIterator = collection.iteratorOwnOpinion();
		System.out.println("ownOpinionIterator");
		while (ownOpinionIterator.hasNext()) {
			final TouristPlace place = ownOpinionIterator.next();
			System.out.println(place);
		}

		final Iterator navigatorIterator = collection.iteratorNavigator();
		System.out.println("navigatorIterator");
		while (navigatorIterator.hasNext()) {
			final TouristPlace place = navigatorIterator.next();
			System.out.println(place);
		}

		final Iterator localGuideIterator = collection.iteratorLocalGuide();
		System.out.println("localGuideIterator");
		while (localGuideIterator.hasNext()) {
			final TouristPlace place = localGuideIterator.next();
			System.out.println(place);
		}
	}

	public interface Iterator {
		TouristPlace next();

		boolean hasNext();
	}

	public interface Iterable {

		Iterator iteratorOwnOpinion();

		Iterator iteratorNavigator();

		Iterator iteratorLocalGuide();

	}

	public class TouristPlace {
		private final String name;
		private final Popularity popularity;

		public TouristPlace(final String name, final Popularity popularity) {
			this.name = name;
			this.popularity = popularity;
		}

		@Override
		public String toString() {
			return "TouristPlace [name=" + name + ", popularity=" + popularity + "]";
		}

	}

	public enum Popularity {
		HIGH, MIDDLE, LOW
	}

	public class TouristPlacesCollection implements Iterable {

		private final TouristPlace place1 = new TouristPlace("The Holy Dormition Kyiv Caves Lavra", Popularity.HIGH);
		private final TouristPlace place2 = new TouristPlace("Rynok Square", Popularity.HIGH);
		private final TouristPlace place3 = new TouristPlace("Old Town", Popularity.MIDDLE);
		private final TouristPlace place4 = new TouristPlace("Odessa National Academic Opera and Ballet Theater",
				Popularity.LOW);
		private final TouristPlace place5 = new TouristPlace("Andriivskyi Descent", Popularity.MIDDLE);

		public Iterator iteratorOwnOpinion() {
			return new OwnOpinionIterator(this);
		}

		public Iterator iteratorNavigator() {
			return new NavigatorIterator(this);
		}

		public Iterator iteratorLocalGuide() {
			return new LocalGuideIterator(this);
		}

		public int size() {
			return 5;
		}

		public TouristPlace get(final int index) {
			switch (index) {
			case 0:
				return place1;
			case 1:
				return place2;
			case 2:
				return place3;
			case 3:
				return place4;
			case 4:
				return place5;
			}
			return null;
		}

	}

	public class OwnOpinionIterator implements Iterator {

		private final TouristPlacesCollection collection;
		private int index;

		public OwnOpinionIterator(final TouristPlacesCollection collection) {
			this.collection = collection;
		}

		public TouristPlace next() {
			return collection.get(index++);
		}

		public boolean hasNext() {
			return collection.get(index) != null;
		}

	}

	public class NavigatorIterator implements Iterator {

		private final TouristPlacesCollection collection;
		private final Integer[] indexes;
		private int index;

		public NavigatorIterator(final TouristPlacesCollection collection) {
			this.collection = collection;
			this.indexes = new Integer[collection.size()];
			generateIndexes();
		}

		private void generateIndexes() {
			final Random random = new Random();
			for (int i = 0; i < indexes.length; i++) {
				indexes[i] = nextInt(random);
			}
		}

		private int nextInt(final Random random) {
			final int nextInt = random.nextInt(indexes.length);
			for (int i = 0; i < indexes.length; i++) {
				if (indexes[i] != null && indexes[i] == nextInt) {
					return nextInt(random);
				}
			}
			return nextInt;
		}

		public TouristPlace next() {
			return collection.get(indexes[index++]);
		}

		public boolean hasNext() {
			return index < indexes.length;
		}

	}

	public class LocalGuideIterator implements Iterator {

		private final TouristPlacesCollection collection;
		private final Integer[] indexes;
		private int index;

		public LocalGuideIterator(final TouristPlacesCollection collection) {
			this.collection = collection;
			this.indexes = new Integer[collection.size()];
			generateIndexes();
		}

		private void generateIndexes() {
			final int[] popularityIndex = new int[Popularity.values().length];
			final Integer[][] popularityIndexes = new Integer[Popularity.values().length][collection.size()];
			for (int i = 0; i < collection.size(); i++) {
				final Popularity popularity = collection.get(i).popularity;
				switch (popularity) {
				case LOW:
					popularityIndexes[popularity.ordinal()][popularityIndex[popularity.ordinal()]++] = i;
					break;
				case MIDDLE:
					popularityIndexes[popularity.ordinal()][popularityIndex[popularity.ordinal()]++] = i;
					break;
				case HIGH:
					popularityIndexes[popularity.ordinal()][popularityIndex[popularity.ordinal()]++] = i;
					break;
				default:
					break;
				}
			}
			int index = 0;
			for (int i = popularityIndexes.length - 1; i >= 0; i--) {
				final Integer[] popularity = popularityIndexes[i];
				for (int j = 0; j < popularity.length; j++) {
					if (popularity[j] != null) {
						indexes[index++] = popularity[j];
					}
				}
			}
		}

		public TouristPlace next() {
			return collection.get(indexes[index++]);
		}

		public boolean hasNext() {
			return index < indexes.length;
		}

	}
}
