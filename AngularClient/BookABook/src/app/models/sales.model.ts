export interface Sales {
    id: string;
    client: string;
    product: string;
    paymentMethod: string;
    discount: number;
    total: number;
    createdAt: Date;
}
